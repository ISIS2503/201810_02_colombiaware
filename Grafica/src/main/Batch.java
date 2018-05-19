
package main;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import interfaz.InterfazS;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
public class Batch implements MqttCallback {


	private static final String brokerUrl = "tcp://157.253.154.50:8083";

	private static final String clientId = "up";
	public static final String PUERTA_ABIERTA = "PA";
	public static final String APERTURA_SOSPECHOSA = "Batch";
	public static final String ACCESO_NP = "suspicious attempt";
	public static final String HUB_IN = "Batch";
	public static final String CERRADURA_IN = "Batch";
	
	public static final String MOTION_DETECTED = "motion detected";
	public static final String LOW_BATTERY = "low battery";
	public static final String LONG_OPENING = "long opening";


	private static final String topic = "#";

	public static ArrayList<String> todasAlertas = new ArrayList<>();
	
	public static ArrayList<String> puertaAbierta = new ArrayList<>();
	public static ArrayList<String> aperturaNP = new ArrayList<>();
	public static ArrayList<String> aperturaS = new ArrayList<>();
	public static ArrayList<String> bateriaC = new ArrayList<>();
	public static ArrayList<String> cerraduraFL = new ArrayList<>();
	public static ArrayList<String> hubFL = new ArrayList<>();



	private InterfazS is;
	public Batch(InterfazS is) {
		this.is = is;

	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	//    public static void main(String[] args) {
	//
	////        new Batch().subscribe(topic);
	//    }

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
		String asunto= message.toString();
		String inmueble = topic.split("\\.")[3];

		if(asunto.equals(PUERTA_ABIERTA))
		{
			puertaAbierta.add(inmueble);
			todasAlertas.add(PUERTA_ABIERTA+":::"+inmueble);
			is.actualizar(PUERTA_ABIERTA+":::"+inmueble);
			System.out.println(todasAlertas.size());
		}
		else if(asunto.equals(APERTURA_SOSPECHOSA))
		{
			System.out.println("Entró");
			aperturaS.add(inmueble);
			todasAlertas.add(APERTURA_SOSPECHOSA+":::"+inmueble);
			is.actualizar(APERTURA_SOSPECHOSA+":::"+inmueble);
		}
		else if(asunto.equals(ACCESO_NP))
		{
			aperturaNP.add(inmueble);
			todasAlertas.add(ACCESO_NP+":::"+inmueble);
			is.actualizar(ACCESO_NP+":::"+inmueble);
		}
		else if(asunto.equals(HUB_IN))
		{
			hubFL.add(inmueble);
			todasAlertas.add(HUB_IN+":::"+inmueble);
			is.actualizar(HUB_IN+":::"+inmueble);
		}
		else if(asunto.equals(CERRADURA_IN))
		{
			cerraduraFL.add(inmueble);
			todasAlertas.add(CERRADURA_IN+":::"+inmueble);
			is.actualizar(CERRADURA_IN+":::"+inmueble);
		}

	}


	public ArrayList<String> getPuertaAbierta() {
		return puertaAbierta;
	}

	public ArrayList<String> getAperturaNP() {
		return aperturaNP;
	}

	public ArrayList<String> getAperturaS() {
		System.out.println(aperturaS);
		return aperturaS;
	}

	public ArrayList<String> getBateriaC() {
		return bateriaC;
	}

	public ArrayList<String> getCerraduraFL() {
		return cerraduraFL;
	}

	public ArrayList<String> getHubFL() {
		return hubFL;
	}

	public ArrayList<String> getTodas() {
		return todasAlertas;
	}


}
