/*******************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package  main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.Timer;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

 class Publisher {

	public static void main(String[] args) throws Exception {
		//enviarMensaje();
		messageArrived();
    }
    
    public static void enviarMensaje(String mensaje)
    {
    	
        String topic = "colombia.bogota.residencia1.inmueble1.1.lector";
        //String content = "DELETE_ALL_PASSWORDS;\n";
        String content = mensaje;
        int qos = 2;
        String broker = "tcp://172.24.42.100:8083";
        String clientId = "JavaSample";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: " + broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: " + content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");
            sampleClient.disconnect();
            System.out.println("Disconnected");
                        
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
            
        }
    }
    public static void messageArrived() throws Exception {

    	
  
    	final Runnable tarea = new Runnable() {
    		  public void run() {
    		    envioPeticion();
    		  }
    		};
    		ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
    		timer.scheduleAtFixedRate(tarea, 1, 20 , TimeUnit.SECONDS);
 
    }
    
    public static void envioPeticion()
    {
    	Date date = new Date();
		//Caso 1: obtener la hora y salida por pantalla con formato:
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		String h= hourFormat.format(date);
		String c1= h.split(":")[0];
		String c2= h.split(":")[1];
		String horario = c1+":"+c2+":00";
    	URL obj;
		try {
			obj = new URL("http://172.24.42.66:8080/claves/"+horario);
		
    	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			
			con.setRequestProperty("Accept-Charset", "UTF-8");
	 
			
			System.out.println("Response Code : " + con.getResponseCode());
			System.out.println("Response Message : " + con.getResponseMessage());
	 
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String line;
			StringBuffer response = new StringBuffer();
	 
			while ((line = in.readLine()) != null) {
				response.append(line);
				System.out.println(""+line);
				if(line!=null)
				{
					if (line.contains("borrar"))
					{
						enviarMensaje("DELETE_PASSWORD;"+line.split(":")[1]+"\n");
					}
					else if (line.contains("agregar"))
					{
						enviarMensaje("ADD_PASSWORD;"+line.split(":")[1]+"\n");
					}
					
				}
				
			}
			in.close();
			
	 
			 	    
    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}}
