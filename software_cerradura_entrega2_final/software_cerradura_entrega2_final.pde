#include <EEPROM.h>
//CONSTANTE DE TAMAÑO DE CONTRASEÑA
const int TAMANIOCONTRASENIA = 4;
const long TIMEFORHEALTHCHECK = 60000;
#define SIZE_BUFFER_DATA       50
boolean     stringComplete = false;
String      inputString = "";
char        bufferData [SIZE_BUFFER_DATA];
//CONSTANTES DE ORDENES
const String ADD_PASSWORD = "ADD_PASSWORD";
const String CHANGE_PASSWORD = "CHANGE_PASSWORD";
const String DELETE_PASSWORD = "DELETE_PASSWORD";
const String DELETE_ALL_PASSWORDS = "DELETE_ALL_PASSWORDS";

//CONSTANTES DE ALARMAS
const int DEVICE_ID = 1;

const String MOTION_DETECTED = "motion detected";
const String SUSPICIOUS_ATTEMPT = "suspicious attempt";
const String LOW_BATTERY = "low battery";
const String LONG_OPENING = "long opening";
//CONSTANTES DE TIPO DE APERTURA
const int OPENEDBYCODE = 0;
const int OPENEDBYMANUAL = 1;
//Battery Led Pin
const int BATTERY_LED = 16;

//Battery Analog Pin
const int BATTERY_PIN = 24;
//Minimum voltage required for an alert
const double MIN_VOLTAGE = 1.2;
//CONSTANTES DE TIEMPO DE ALARMAS
const int BATTERY_ALARM_DELAYER = 30000;

const int DOOR_ALARM_DELAYER = 30000;
//Current battery charge
double batteryCharge;

const int BUZZER_PIN = 17;

//Button pin
const int CONTACT_PIN = 11;

//R LED pin
const int R_LED_PIN = 13;

//G LED pin
const int G_LED_PIN = 12;

//B LED pin
const int B_LED_PIN = 10;
//Battery current status, true for critical, false for normal.
boolean BATTERY_STATUS;
//Control for the battery alarm.
boolean BATTERY_FIRST_TIME_CONTROL;
//Control for the long opening Alarm.
boolean DOOR_ALARM_FIRST_TIME_CONTROL;
//Door state
boolean open;
long timeForNextSerialAlarm;
//Attribute that defines the button state
boolean buttonState;
//Attribute that contains the time since last alarm emission.
long batteryTime;
//Current time when the button is tapped
long currTime;

//Number of current attempts
byte attempts;

long timeHealthCheckLast;
long timeHealthCheckNow;
/*
* PIR sensor tester
 */

int ledPin = 15;                // choose the pin for the LED
int inputPin = 14;               // choose the input pin (for PIR sensor)
int pirState = LOW;             // we start, assuming no motion detected
int val = 0;                    // variable for reading the pin status

#include <Keypad.h>


//Time in milliseconds which the system is locked
const int LOCK_TIME = 3000;

int OPEN_TIME = 0;
//Keypad rows
const byte ROWS = 4; 

//Keypad columns
const byte COLS = 3;

//Maximum number of attempts allowed
const byte maxAttempts = 3;



//Keypad mapping matrix
char hexaKeys[ROWS][COLS] = {
  {
    '1', '2', '3'
  }
  ,
  {
    '4', '5', '6'
  }
  ,
  {
    '7', '8', '9'
  }
  ,
  {
    '*', '0', '#'
  }
};

//Keypad row pins definition
byte rowPins[ROWS] = {
  9, 8, 7, 6
}; 

//Keypad column pins definition
byte colPins[COLS] = {
  5, 4, 3
};

//Keypad library initialization
Keypad customKeypad = Keypad(makeKeymap(hexaKeys), rowPins, colPins, ROWS, COLS); 

//Current key variable
String currentKey;
//If the number of current attempts exceeds the maximum allowed
boolean block;


void setup()
{
  Serial.begin(9600);
  timeHealthCheckNow = millis();
  deleteAllPasswords();
  addPassword(1234, 1);
  currentKey = "";
  open = false;
  BATTERY_FIRST_TIME_CONTROL = true;
  DOOR_ALARM_FIRST_TIME_CONTROL = true;
  attempts = 0;
  block = false;
  BATTERY_STATUS = false;
  Serial.begin(9600);
  buttonState = false;
  // Ouput pin definition for BATTERY_LED
  pinMode(BATTERY_LED,OUTPUT);
  //Input pin definition for battery measure
  pinMode(BATTERY_PIN,INPUT);

  pinMode(R_LED_PIN, OUTPUT);
  pinMode(G_LED_PIN, OUTPUT);
  pinMode(B_LED_PIN, OUTPUT);
  pinMode(CONTACT_PIN,INPUT);

  setColor(0, 0, 255);

  pinMode(ledPin, OUTPUT);      // declare LED as output
  pinMode(inputPin, INPUT);     // declare sensor as input
  pinMode(BUZZER_PIN, OUTPUT);      // Pin que determina la salida de sonido del Buzzer.
  Serial.begin(9600);
}

void loop()
{
  sendHealthcheck();
  //Value conversion from digital to voltage
  batteryCharge = (analogRead(BATTERY_PIN)*5.4)/1024;
  batteryChecker();
  char customKey;
  val = digitalRead(inputPin);  // read input value

  if (val == HIGH) {            // check if the input is HIGH
    digitalWrite(ledPin, HIGH);  // turn LED ON
    if (pirState == LOW) {
      // we have just turned on
      alarmEmitter(MOTION_DETECTED);
      // We only want to print on the output change, not state
      pirState = HIGH;
    }
  } 
  else {
    digitalWrite(ledPin, LOW); // turn LED OFF
    if (pirState == HIGH) {
      // we have just turned of
      //Serial.println("Motion ended!");
      // We only want to print on the output change, not state
      pirState = LOW;
    }
  }
  //Button input read and processing 
  if(!buttonState) {
    if(digitalRead(CONTACT_PIN)) {
      currTime = millis();
      buttonState = true;
      //setColor(0, 255, 0);
      openDoor();
      doorChecker(OPENEDBYMANUAL);
      attempts = 0;
    }
  }
  else {
    if(digitalRead(CONTACT_PIN)) {
      if((millis()-currTime)>=3000) {
//        setColor(0, 0, 255);
        setRedStatus(true);
        alarmEmitter(LONG_OPENING);
        //Serial.println("Door opened too much time!!");
      }
    }
    else {
      //setColor(0, 255, 0);
      closeDoor();
      setRedStatus(false);
      buttonState = false;
      //Serial.println("Door closed!!");
      OPEN_TIME = 0;
    }
  }
  if(!block) {
    //Selected key parsed;
    customKey = customKeypad.getKey();
  }
  else {
    //Serial.println("Number of attempts exceeded");
    while(true);
  }

  //Verification of input and appended value
  if (customKey) {  
    currentKey+=String(customKey);
    setColor(0,255,0);
    setColor(0,0,255);
    //Serial.println(currentKey);
  }
  //Borrar Intento actual.
  if(currentKey.endsWith("#")&&currentKey.length()<=TAMANIOCONTRASENIA) {
    currentKey = "";
    //Serial.println("Attempt deleted");
  }
  //Cerrar puerta mediante teclado.
  //If the current key contains '*' and door is open
  //if(open && currentKey.endsWith("*")) {
    //closeDoor();
    //Serial.println("Door closed");
    //digitalWrite(10,LOW);
    //currentKey = "";
    //OPEN_TIME = 0;
  //}
  //If the current key contains '#' reset attempt
  
  //Abrir puerta mediante teclado.
  //If current key matches the key length
  if (currentKey.length()== TAMANIOCONTRASENIA) {
    if(compareKey(currentKey)) {
      //digitalWrite(10,HIGH);
      //open = true;
      //Serial.println("Door opened!!");
      openDoor();
      doorChecker(OPENEDBYCODE);
      //setColor(0,255,0);
      attempts = 0;
    }
    else {
      attempts++;
      currentKey = "";
      setRedStatus(true);
      delay(1000);
      setRedStatus(false);
      //Serial.println("Number of attempts: "+String(attempts));
    }
  }
  //else if(currentKey.length()> KEY.length()) {
    //Serial.println("Door opened!!");
  //}
  if(attempts>=maxAttempts) {
    currentKey = "";
    attempts = 0;
    alarmEmitter(SUSPICIOUS_ATTEMPT);
    //Serial.println("System locked");
    setRedStatus(true);
    delay(LOCK_TIME);
    //TODO: EMITIR ALERTA DE INTENTO SOSPECHOSO.
    //Serial.println("System unlocked");
    setRedStatus(false);
  }
  //Zona de Procesamiento de comandos
  receiveData();
  processData();
  
  delay(100);
}

//Method that outputs the RGB specified color
void setColor(int redValue, int greenValue, int blueValue) {
  analogWrite(R_LED_PIN, redValue);
  analogWrite(G_LED_PIN, greenValue);
  analogWrite(B_LED_PIN, blueValue);
}

void openDoor()
{
  open = true;
  setColor(0,255,0);
}
void closeDoor()
{
  open = false;
  setColor(0,0,255);
}

void setRedStatus(boolean status)
{
  if(status)
  {
    setColor(255,0,0);
    setBuzzer(true);
  }
  else
  {
    setColor(0,0,255);
    setBuzzer(false);
  }
}

void setBuzzer(boolean status)
{
  if(status)
  {
    digitalWrite(BUZZER_PIN, HIGH);
  }
  else
  {
    digitalWrite(BUZZER_PIN, LOW);
  } 
}

void alarmEmitter(String dato)
{
  String respuesta = "{\"id\":";
  respuesta += DEVICE_ID;
  respuesta += ",\"alert\":\"" + dato + "\"}";
  Serial.println(respuesta);
}

void doorChecker(int openingMethod)
{
  currTime = millis();
  timeForNextSerialAlarm = millis();
  while(open)
  {	
	if((millis()-currTime)>=DOOR_ALARM_DELAYER) 
	{
          setRedStatus(true);
          //Serial.println("Door opened too much time!!");
          if(DOOR_ALARM_FIRST_TIME_CONTROL||(millis()-timeForNextSerialAlarm)>=10000)
          {
            DOOR_ALARM_FIRST_TIME_CONTROL = false;
            timeForNextSerialAlarm = millis();
            alarmEmitter(LONG_OPENING);
          }
        }
	if(openingMethod == OPENEDBYMANUAL)
	{
	  if(!digitalRead(CONTACT_PIN))
	  {
            DOOR_ALARM_FIRST_TIME_CONTROL = true;
	    closeDoor();
            setRedStatus(false);
	    buttonState = false;
	    OPEN_TIME = 0;
          }
	}
	else if(openingMethod == OPENEDBYCODE)
	{
          char customKey;
          customKey = customKeypad.getKey();
          if (customKey)
          {  
            currentKey+=String(customKey);
            //Serial.println(currentKey);
          }
	  if(currentKey.endsWith("*"))
	  {
            setRedStatus(false);
	    closeDoor();
            DOOR_ALARM_FIRST_TIME_CONTROL = true;
	    currentKey = "";
	    OPEN_TIME = 0;
	  }
	}
  }
}

void batteryChecker()
{
  //Measured value comparison with min voltage required
  if(batteryCharge<=MIN_VOLTAGE)
  {
    BATTERY_STATUS = true;
  }
  else
  {
    BATTERY_STATUS = false;
    BATTERY_FIRST_TIME_CONTROL = true;
    //setBuzzer(false);
  }
  if(BATTERY_STATUS)
  {
    digitalWrite(BATTERY_LED,HIGH);
    if(((millis()-batteryTime) >= BATTERY_ALARM_DELAYER)||BATTERY_FIRST_TIME_CONTROL)
    {
      BATTERY_FIRST_TIME_CONTROL = false;
      batteryTime = millis();	
      alarmEmitter(LOW_BATTERY);
      setBuzzer(true);
      delay(2000);
      setBuzzer(false);
    }
  }
  else
  {
    digitalWrite(BATTERY_LED,LOW);
  }
  
}
//Entrega 2 parcial
// Method that compares a key with stored keys
boolean compareKey(String key) {
  int acc = 3;
  int codif, arg0, arg1; 
  for(int i=0; i<3; i++) {
    codif = EEPROM.read(i);
    while(codif!=0) {
      if(codif%2==1) {
        arg0 = EEPROM.read(acc);
        arg1 = EEPROM.read(acc+1)*256;
        arg1+= arg0;
        if(String(arg1)==key) {
          return true;
        }
      }
      acc+=2;
      codif>>=1;
    }
    acc=(i+1)*16+3;
  }
  return false;
}

// Methods that divides the command by parameters
void processCommand(String* result, String command) {
  int i = 0;
  char* token;
  char buf[command.length() + 1];
  
  command.toCharArray(buf, sizeof(buf));
  token = strtok(buf, ";");
  
  while(token != NULL) {
    result[i++] = token;
    token = strtok(NULL, ";");
  }
}

//Method that adds a password in the specified index
void addPassword(int val, int index) {
  byte arg0 = val%256;
  byte arg1 = val/256;
  EEPROM.write((index*2)+3,arg0);
  EEPROM.write((index*2)+4,arg1);
  byte i = 1;
  byte location = index/8;
  byte position = index%8;
  i<<=position;
  byte j = EEPROM.read(location);
  j |= i;
  EEPROM.write(location,j);
}

//Method that updates a password in the specified index
void updatePassword(int val, int index) {
  byte arg0 = val%256;
  byte arg1 = val/256;
  EEPROM.write((index*2)+3,arg0);
  EEPROM.write((index*2)+4,arg1);
}

//Method that deletes a password in the specified index
void deletePassword(int index) {
  byte i = 1;
  byte location = index/8;
  byte position = index%8;
  i<<=position;
  byte j = EEPROM.read(location);
  j ^= i;
  EEPROM.write(location,j);
}

//Method that deletes all passwords
void deleteAllPasswords() {
  //Password reference to inactive
  EEPROM.write(0,0);
  EEPROM.write(1,0);
  EEPROM.write(2,0);
}

void receiveData() {
  while (Serial.available()) {
    // get the new byte:
    char inChar = (char)Serial.read();
    // add it to the inputString:
    inputString += inChar;
    if (inChar == '\n') {
      inputString.toCharArray(bufferData, SIZE_BUFFER_DATA);
      stringComplete = true;
    }
  }
}

void processData() {
  if (stringComplete) {
    String resultado[3];
    processCommand(resultado, inputString);
    for(int i=0; i<3; i++)
    {
      //Serial.println(resultado[i]);
    }
    if(resultado[0] == ADD_PASSWORD)
    {
      addPassword(resultado[2].toInt(),resultado[1].toInt());
    }
    else if(resultado[0] == CHANGE_PASSWORD)
    {
      updatePassword(resultado[2].toInt(),resultado[1].toInt());
    }
    else if(resultado[0] == DELETE_PASSWORD)
    {
      deletePassword(resultado[1].toInt());
    }
    else if(resultado[0] == DELETE_ALL_PASSWORDS)
    {
      deleteAllPasswords();
    }
    else
    {
    }
    inputString = "";
    stringComplete = false;
  }
}

void sendHealthcheck()
{
  timeHealthCheckNow = millis();
  if((timeHealthCheckLast+TIMEFORHEALTHCHECK) <= timeHealthCheckNow)
  {
    timeHealthCheckLast = timeHealthCheckNow;
    Serial.println("HEALTHCHECK");
  }
}
