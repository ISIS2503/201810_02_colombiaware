package interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class CI {

	public static JPanel panelBorde(JPanel panel, String text) {		
		TitledBorder b = BorderFactory.createTitledBorder(text);
		b.setTitleColor(Color.WHITE);
		panel.setBorder(b);
		return panel;
	}
	
	public static JLabel ponerImagen(String rutaImagen) {
		return new JLabel(new ImageIcon(rutaImagen));
	}
	
	public static JLabel ponerImagen(String rutaImagen, int width, int height ) { //criaturas 300 * 300 
		JLabel ret = new JLabel();
		ret.setBounds(0, 0, width, height); 
		ret.setIcon(new ImageIcon(new ImageIcon(rutaImagen).getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT)));
		return ret;
	}
	
	public static JLabel etiqueta(String txt) {
		JLabel ret = new JLabel(txt,JLabel.LEFT);
		ret.setForeground(Color.WHITE);
		ret.setFont( new Font("Helvetica", Font.BOLD, 15) );
		return ret;
	}
	
	public static JLabel etiqueta(String txt, int size, Color color) {
		JLabel ret = new JLabel(txt,JLabel.LEFT);
		ret.setForeground(color);
		ret.setFont( new Font("Helvetica", Font.BOLD, size) );
		return ret;
	}
	
	public static JPanel panelGrid(int rows, int cols, Component... c) {
		JPanel ret = new JPanel();
		ret.setOpaque(false);
		ret.setLayout(new GridLayout(rows, cols));
		for (Component component : c) ret.add(component);		
		return ret;
	}

	public static JButton crearBoton(String nombre, ActionListener oidor) {
		JButton ret = new JButton(nombre);
		ret.setActionCommand(nombre);
		ret.addActionListener(oidor);
		return ret;
	}

	public static void inhabilitar(Component ...components) {
		for (Component component : components) component.setEnabled(false);
	}
	
	public static void habilitar(Component ...components) {
		for (Component component : components) component.setEnabled(true);
	}
	
	public static void opaco(JTextField ...components) {
		for (JTextField component : components) component.setOpaque(false);
	}
	
	public static void msgInfo(Component c ,String msg, String cabecera) {
		JOptionPane.showMessageDialog(c, msg, cabecera, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void msgError(Component c ,String msg, String cabecera) {
		JOptionPane.showMessageDialog(c, msg, cabecera, JOptionPane.ERROR_MESSAGE);
	}
	
	public static void msgWar(Component c ,String msg, String cabecera) {
		JOptionPane.showMessageDialog(c, msg, cabecera, JOptionPane.WARNING_MESSAGE);
	}

	
	public static String inMsg(Component c ,String msg) {
		return JOptionPane.showInputDialog(c,msg);
	}
}
