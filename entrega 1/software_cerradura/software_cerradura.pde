//Button pin
const int CONTACT_PIN = 11;

//R LED pin
const int R_LED_PIN = 13;

//G LED pin
const int G_LED_PIN = 12;

//B LED pin
const int B_LED_PIN = 10;

//Door state
boolean open;

//Attribute that defines the button state
boolean buttonState;

//Current time when the button is tapped
long currTime;

//Number of current attempts
byte attempts;

/*
* PIR sensor tester
*/
 
int ledPin = 15;                // choose the pin for the LED
int inputPin = 14;               // choose the input pin (for PIR sensor)
int pirState = LOW;             // we start, assuming no motion detected
int val = 0;                    // variable for reading the pin status

#include <Keypad.h>

//Specified password
const String KEY = "1234";

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
  currentKey = "";
  open = false;
  attempts = 0;
  block = false;

  Serial.begin(9600);
  buttonState = false;
  
  pinMode(R_LED_PIN, OUTPUT);
  pinMode(G_LED_PIN, OUTPUT);
  pinMode(B_LED_PIN, OUTPUT);
  pinMode(CONTACT_PIN,INPUT);
  
  setColor(0, 0, 255);

  pinMode(ledPin, OUTPUT);      // declare LED as output
  pinMode(inputPin, INPUT);     // declare sensor as input
 
  Serial.begin(9600);
}

void loop()
{
  char customKey;
  val = digitalRead(inputPin);  // read input value
  
  if (val == HIGH) {            // check if the input is HIGH
    digitalWrite(ledPin, HIGH);  // turn LED ON
    if (pirState == LOW) {
      // we have just turned on
      Serial.println("Motion detected!");
      // We only want to print on the output change, not state
      pirState = HIGH;
    }
  } else {
    digitalWrite(ledPin, LOW); // turn LED OFF
    if (pirState == HIGH){
      // we have just turned of
      Serial.println("Motion ended!");
      // We only want to print on the output change, not state
      pirState = LOW;
    }
  }
   //Button input read and processing 
  if(!buttonState) {
    if(digitalRead(CONTACT_PIN)) {
      currTime = millis();
      buttonState = true;
      setColor(250, 250, 250);
      open = true;
      attempts = 0;
      Serial.println("Door opened!!");
    }
  }
  else {
    if(digitalRead(CONTACT_PIN)) {
      if((millis()-currTime)>=3000) {
        setColor(0, 0, 255);
        Serial.println("Door opened too much time!!");
      }
    }else{
      setColor(0, 255, 0);
      open = false;
      buttonState = false;
      Serial.println("Door closed!!");
      OPEN_TIME = 0;
    }
  }
  if(!block) {
    //Selected key parsed;
    customKey = customKeypad.getKey();
  }
  else {
    Serial.println("Number of attempts exceeded");
    while(true);
  }

  //Verification of input and appended value
  if (customKey) {  
    currentKey+=String(customKey);
    Serial.println(currentKey);
  }

  //If the current key contains '*' and door is open
  if(open && currentKey.endsWith("*")) {
    open = false;
    Serial.println("Door closed");
    digitalWrite(10,LOW);
    currentKey = "";
    OPEN_TIME = 0;
  }
  //If the current key contains '#' reset attempt
  if(currentKey.endsWith("#")&&currentKey.length()<=KEY.length()) {
    currentKey = "";
    Serial.println("Attempt deleted");
  }

  //If current key matches the key length
  if (currentKey.length()== KEY.length()) {
    if(currentKey == KEY) {
      digitalWrite(10,HIGH);
      open = true;
      Serial.println("Door opened!!");
      attempts = 0;
    }
    else {
      attempts++;
      currentKey = "";
      Serial.println("Number of attempts: "+String(attempts));
    }
  }else if(currentKey.length()> KEY.length()){
    Serial.println("Door opened!!");
  }
  if(attempts>=maxAttempts) {
    currentKey = "";
    attempts = 0;
    Serial.println("System locked");
    delay(LOCK_TIME);
    Serial.println("System unlocked");
  }

  if(open)
  {
    OPEN_TIME = OPEN_TIME + 1;
  }
  if(open && OPEN_TIME >= 30)
  {
    Serial.println("Door opened too much time!!");
  }
  delay(100);
}

//Method that outputs the RGB specified color
void setColor(int redValue, int greenValue, int blueValue) {
  analogWrite(R_LED_PIN, redValue);
  analogWrite(G_LED_PIN, greenValue);
  analogWrite(B_LED_PIN, 255-blueValue);
}
