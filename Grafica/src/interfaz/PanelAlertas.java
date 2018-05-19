package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.Batch;

/**
 * Panel que muestra la información de las empresas
 */
public class PanelAlertas extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante con los nombres de las columnas de la tabla de empresas visitantes
     */
//    public static final String[] NOMBRE_COLUMNAS_ALERTAS = { "Tipo", "Inmueble" };


    

  

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la interfaz
     */
    private InterfazS principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Tabla que muestra la información de las empresas visitantes
     */
//    private JTable tablaAlertas;

    
    /**
     * Modelo para visualizar la información en la tabla de visitantes
     */
//    private DefaultTableModel modelAlarmas;

   
    

    /**
     * Botón desocupar puesto
     */
//    private JButton botonDesocuparPuesto;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con las empresas
     */
    
    public JList<String> lista;
    
    public PanelAlertas( InterfazS nPrincipal, Batch nFeriaEmpresarial )
    {
        principal = nPrincipal;
        setLayout(new GridLayout(1, 1));
        this.setOpaque(false);
        setBorder(BorderFactory.createTitledBorder("Alertas"));
        add(new JScrollPane(lista = crearLista()));
    }
    
    public JList<String> crearLista() {
		JList<String> ret = new JList<String>(new DefaultListModel<String>());
		ret.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}			
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] data = lista.getSelectedValue().split(":::");
				CI.msgError(principal, "El inmueble "+data[1]+" se presento una dificultad:\n"+mensage(data[0]), "Alerta");
				
			}
		});
		return ret;
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

    /**
     * Actualiza la visualización de las empresas
     */
    public void actualizar( String alarma )
    {
    	DefaultListModel<String> model = (DefaultListModel<String>) lista.getModel();
		model.addElement(alarma);
		this.validate();
		CI.msgWar(principal, "Ocurrió una alerta", "Mensaje alerta");
		
    }

    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
    }
}
