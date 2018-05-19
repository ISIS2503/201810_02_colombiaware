package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import main.Batch;

public class Mapa extends JPanel implements ActionListener {

	private JButton[][] mapa;
	private String ultimaAlerta = "";


	public Mapa() {
		int fila = 6;
		int columna = 6;
		int c = 1;

		setOpaque(false);
		setLayout(new GridLayout(fila, columna));

		setBorder(BorderFactory.createTitledBorder("Mapa de unidades residenciales"));

		mapa = new JButton[fila][columna];
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[0].length; j++) {
				mapa[i][j] = new JButton("In: "+(c++));
				mapa[i][j].addActionListener(this);
				mapa[i][j].setActionCommand(i+","+j);
				mapa[i][j].setBackground(Color.WHITE);
				add(mapa[i][j]);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] data = e.getActionCommand().split(",");
		int f = Integer.parseInt(data[0]);
		int c = Integer.parseInt(data[1]);

		mapa[f][c].setBackground(Color.WHITE);
		String[] data2 = ultimaAlerta.split(":::");
		CI.msgError(null, "El inmueble "+mapa[f][c].getText().split("In: ")[1]+" se presento una dificultad:\n"+mensage(data2[0]), "Alerta");
		ultimaAlerta = "";
	}

	private String mensage(String tipo) {
		if(tipo.equals(Batch.PUERTA_ABIERTA)) {
			return "La puesta se ha dejado mucho timepo abierta";
		} else if(tipo.equals(Batch.APERTURA_SOSPECHOSA)) {
			return "Alguien ha intentado abrir la puesta";
		} else if(tipo.equals(Batch.ACCESO_NP)) {
			return "Alguien ha entrado sin autorización";
		} else if(tipo.equals(Batch.HUB_IN)) {
			return "El hub se encuentra inhabilidato";
		} else if(tipo.equals(Batch.CERRADURA_IN)) {
			return "La cerradura se encuentra inhabilidato";
		} else if(tipo.equals(Batch.MOTION_DETECTED)) {
			return "Se detecto movimiento";
		} else if(tipo.equals(Batch.LOW_BATTERY)) {
			return "Batería baja";
		} else if(tipo.equals(Batch.LONG_OPENING)) {
			return "Puerta abierta";
		}

		return null;
	}

	public void resaltar(int c, String alarma) {
		ultimaAlerta = alarma;
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[0].length; j++) {
				if(mapa[i][j].getText().endsWith(c+"")) {
					mapa[i][j].setBackground(Color.RED);
					this.validate();
					return;
				}
			}
		}
	}

}
