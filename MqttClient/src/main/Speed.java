
package main;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class Speed implements MqttCallback {
	
    /** The broker url. */
    private static final String brokerUrl = "tcp://172.24.42.100:8083";

    /** The client id. */
    private static final String clientId = "Speed";

    /** The topic. */
    private static final String topic = "#";

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {

        new Speed().subscribe(topic);
    }

    /**
     * Subscribe.
     *
     * @param topic
     *            the topic
     */
    public void subscribe(String topic) {

        MemoryPersistence persistence = new MemoryPersistence();

        try {

            MqttClient sampleClient = new MqttClient(brokerUrl, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);

            System.out.println("checking");

            System.out.println("Mqtt Connecting to broker: " + brokerUrl);
            sampleClient.connect(connOpts);
            System.out.println("Mqtt Connected");

            sampleClient.setCallback(this);
            sampleClient.subscribe(topic);

            System.out.println("Subscribed");
            System.out.println("Listening");

        } catch (MqttException me) {

            System.out.println("Mqtt reason " + me.getReasonCode());
            System.out.println("Mqtt msg " + me.getMessage());
            System.out.println("Mqtt loc " + me.getLocalizedMessage());
            System.out.println("Mqtt cause " + me.getCause());
            System.out.println("Mqtt excep " + me);
        }
    }

    
    public void connectionLost(Throwable arg0) {
    	System.out.println("Conexion perdida");
    	arg0.printStackTrace();

    }

    public void deliveryComplete(IMqttDeliveryToken arg0) {

    }
    
    public void messageArrived(String topic, MqttMessage message) throws Exception {
    	 

        System.out.println("Mqtt topic : " + topic);
        System.out.println("Mqtt msg : " + message.toString());
        String correoR = topic.split("\\.")[3]+"@correo.com.co";
        String asunto = "NOTIFICACION ALARMA";
        String mensaje= message.toString();
        String correoD = correoR;
     
         	

        String peticion2 = "{\"correoR\":\""+ correoR+"\", \"correoD\":\""+correoD+"\", \"asunto\":\""+asunto +"\", \"mensaje\":\""+mensaje+"\""+"}";
        System.out.println(peticion2);
    	URL url2 = new URL("http://172.24.42.100:8080/programaE");
        HttpURLConnection con2 = (HttpURLConnection) url2.openConnection();
    	con2.setRequestMethod("POST");
    	con2.setRequestProperty("Content-Type", "application/text");
    	con2.setDoOutput(true);
    	OutputStream ss2 = con2.getOutputStream();
    	ss2.write(peticion2.toString().getBytes());
    	ss2.flush();
    	ss2.close();
    	
        
        
        
         
     
        
    }

}
