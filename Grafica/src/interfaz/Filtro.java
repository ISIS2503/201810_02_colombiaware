package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Batch;

public class Filtro extends JPanel{

	private JComboBox<String> filtro;
	private InterfazS interfaz;
	
	/*public static final String PUERTA_ABIERTA = "PA";
	public static final String APERTURA_SOSPECHOSA = "Batch";
	public static final String ACCESO_NP = "Batch";
	public static final String HUB_IN = "Batch";
	public static final String CERRADURA_IN = "Batch";*/

	public Filtro(InterfazS interfaz) {
		this.interfaz = interfaz;
		this.setOpaque(false);
		this.setLayout(new GridLayout(1, 5));
		this.setBorder(BorderFactory.createTitledBorder("Filtros"));

		filtro = new JComboBox<>();
		filtro.addItem(Batch.PUERTA_ABIERTA);
		filtro.addItem(Batch.APERTURA_SOSPECHOSA);
		filtro.addItem(Batch.ACCESO_NP);
		filtro.addItem(Batch.HUB_IN);
		filtro.addItem(Batch.CERRADURA_IN);
		filtro.addItem(Batch.LONG_OPENING);
		filtro.addItem(Batch.LOW_BATTERY);
		filtro.addItem(Batch.MOTION_DETECTED);
		
		
		this.add(new JLabel());
		this.add(filtro);
		this.add(new JLabel());
		this.add(CI.crearBoton("Filtra", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String r = (String) filtro.getSelectedItem();
				CI.msgInfo(interfaz, generrMensaje(r), "Filtro");
			}
		}));
		this.add(new JLabel());
	}

	private String generrMensaje(String tipo) {
		return crear(interfaz.darLista(tipo));
		
	}
	
	private String crear(List<String> l) {
		System.out.println(l);
		return l.stream().map((s) -> s + "\n").reduce("", String::concat);
	}
	
	


}
