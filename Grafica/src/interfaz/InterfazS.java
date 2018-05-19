
package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import main.Batch;


/**
 * Esta es la ventana principal de la aplicación.
 */
public class InterfazS extends JFrame
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo
     */
    private Batch feriaEmpresarial;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel que representa los puestos de la feria
     */
    private PanelAlertas panelAlertas;

   
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la interfaz
     */
    private Mapa mapa;
    private Filtro filtro;
    public InterfazS( )
    {
        // Crea la clase principal
        feriaEmpresarial = new Batch(this);
        mapa = new Mapa();

        // Construye la forma
        getContentPane( ).setLayout( new BorderLayout( ) );
        setTitle( "Control seguridad" );
        setSize( 800, 600 );
        setResizable( false );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        getContentPane( ).setBackground( Color.WHITE );

        // Creación de los paneles aquí
        panelAlertas = new PanelAlertas(this,feriaEmpresarial);
        add( panelAlertas, BorderLayout.WEST );
        add(mapa, BorderLayout.CENTER);
        add(filtro = new Filtro(this), BorderLayout.SOUTH);
        
        // Centrar la ventana
        setLocationRelativeTo( null );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la visualización de la interfaz <br>
     * <b>post: </b> Se actualiza la visualización.
     */
    public void actualizar(String alarma)
    {
       panelAlertas.actualizar(alarma);
       mapa.resaltar(Integer.parseInt(alarma.split(":::")[1].split("inmueble")[1]), alarma);
    }
    
    public List<String> darLista(String tipo) {
    	System.out.println("======================== "+tipo);
    	if(tipo.equals(Batch.PUERTA_ABIERTA)) {
			return feriaEmpresarial.getPuertaAbierta();
		} else if(tipo.equals(Batch.APERTURA_SOSPECHOSA)) {
			return feriaEmpresarial.getAperturaS();
		} else if(tipo.equals(Batch.ACCESO_NP)) {
			return feriaEmpresarial.getAperturaNP();
		} else if(tipo.equals(Batch.HUB_IN)) {
			return feriaEmpresarial.getHubFL();
		} else if(tipo.equals(Batch.CERRADURA_IN)) {
			return feriaEmpresarial.getCerraduraFL();
		}else if(tipo.equals(Batch.MOTION_DETECTED)) {
			return new ArrayList<>();
		} else if(tipo.equals(Batch.LOW_BATTERY)) {
			return new ArrayList<>();
		} else if(tipo.equals(Batch.LONG_OPENING)) {
			return new ArrayList<>();
		}
		return null;
	}
   
    public static void main( String[] args )
    {
        InterfazS interfaz = new InterfazS( );
        interfaz.setVisible( true );
        new Batch(interfaz).subscribe("#");
        
    }

}