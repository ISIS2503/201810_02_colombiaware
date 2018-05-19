
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
import java.util.ArrayList;
import java.util.List;


public class HealthCheck implements MqttCallback {

	/** The broker url. */
	private static final String brokerUrl = "tcp://157.253.146.145:8083";

	/** The client id. */
	private static final String clientId = "HC";

	/** The topic. */
	private static final String topic = "#";

	private int lost = 0;
	private final int MAX_LOST = 3;
	private final int TIME_HEALTH_CHECK = 2000;
	private List<Hilo> hilos = new ArrayList<>();

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		new HealthCheck().subscribe(topic);
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
			connOpts.setUserName("up");
			char[] contra = "contra".toCharArray();
			connOpts.setPassword(contra);

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
		
		String inmueble = topic.split("\\.")[3];
		
		//String id = ciudad+":"+residencia+":"+inmueble;
		String id = inmueble;
		Hilo h = hilos.stream().filter(hilo -> hilo.identificador.equals(id)).findFirst().orElse(null);
		if(h == null) {
			new Thread(h = new Hilo(id)).start();
			hilos.add(h);
			URL url = new URL("http://172.24.42.66:8080/HealthCheck/activar/"+inmueble);
		     HttpURLConnection con = (HttpURLConnection) url.openConnection();
		     con.setRequestMethod("POST");
		     con.setRequestProperty("Content-Type", "application/json");
		     con.setDoOutput(true);
		     OutputStream ss = con.getOutputStream();
		     ss.write(inmueble.toString().getBytes());
		     ss.flush();
		     ss.close();
		} else {
			h.val();
		}

	}
	
	

	private class Hilo implements Runnable {

		private String identificador;
		private boolean validar = false;
		private boolean activo = true;

		public Hilo(String identificador) {
			this.identificador = identificador;
		}

		public void run() {
			while(activo) {
				try {
					Thread.sleep(TIME_HEALTH_CHECK);
					if(validar) {
						lost = 0;
					}
					else {
						lost = lost + 1;
						if(lost == MAX_LOST) {
							 System.out.println("Hub inactivo.\n"+identificador);
							 activo = false;
							 URL url = new URL("http://172.24.42.66:8080/HealthCheck/desactivar/"+identificador);
						     HttpURLConnection con = (HttpURLConnection) url.openConnection();
						     con.setRequestMethod("POST");
						     con.setRequestProperty("Content-Type", "application/json");
						     con.setDoOutput(true);
						     OutputStream ss = con.getOutputStream();
						     ss.write(this.identificador.toString().getBytes());
						     ss.flush();
						     ss.close();
						    hilos.removeIf(x -> x.identificador.equals(identificador));
						    System.gc();
						}
					}
				} catch (Exception ex) {
					System.out.println("Error en conteo de HealthCheck");
				} finally {
					validar = false;
				}
			}
		}

		public void val() {
			validar = true;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Hilo other = (Hilo) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (!identificador.equals(other.identificador))
				return false;
			return true;
		}

		private HealthCheck getOuterType() {
			return HealthCheck.this;
		}
		
		
	}

}
