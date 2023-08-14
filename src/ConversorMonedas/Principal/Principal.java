package ConversorMonedas.Principal;

import ConversorMonedas.function.*;
import ConversorTemperatura.functionTemperatura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

//import javax.swing.JInternalFrame;

//import ConvertirMonedas.function;
public class Principal extends JFrame {
	fondoPanel fondo = new fondoPanel();
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem opcion1;
	private JMenuItem opcion2;
	private JMenuItem opcion3;
	

	public static void main(String[] args) {

		Principal ventana = new Principal();
		

		ventana.setVisible(true);

	}
	
	// contructor
	public Principal() {
        
		this.setContentPane(fondo);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int height = pantalla.height;
		int width = pantalla.width;
		setSize(width / 2, height / 2);
		// tamaño de la ventana
		setLocationRelativeTo(null);

		setTitle("Conversor");// titulo de la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);// para que cuando cierro la ventana se deje de ejecutar la app

		JPanel panel = new JPanel();
		mostrarMenu();
		panel.add(menuBar);
		getContentPane().add(panel);

	}
	

	public void mostrarMenu() {
		// inicialización de los Atributos//
		function monedas = new function();
		functionTemperatura temperatura = new functionTemperatura();
		menuBar = new JMenuBar();
		menu = new JMenu("seleccione una opción de conversión ");
		opcion1 = new JMenuItem("Conversor de Moneda");
		opcion2 = new JMenuItem("conversor de Temperatura");
		opcion3 = new JMenuItem("salir");

		menu.add(opcion1);
		menu.add(opcion2);
		menu.add(opcion3);

		menuBar.add(menu);

		// Opcion Conversor de monedas
		opcion1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				String input = JOptionPane.showInputDialog("Ingresa la cantidad de dinero que deseas convertir: ");
				if (ValidarNumero.ValidarNumero(input) == true) {
					double Minput = Double.parseDouble(input);
					monedas.ConvertirMonedas(Minput);
                    
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas realizar otra conversión?");
					if (JOptionPane.OK_OPTION == respuesta) {
						//System.out.println("Selecciona opción Afirmativa");
					} else {
						JOptionPane.showMessageDialog(null, "Programa terminado");
						System.exit(0);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Valor inválido");
				}
				
			}

		});

		// Opcion Conversor de temperatura
		opcion2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				 String input = JOptionPane.showInputDialog("Ingresa el valor de la temperatura que deseas convertir ");
				if (ValidarNumero.ValidarNumero(input) == true) {
					double Minput = Double.parseDouble(input);
					 temperatura. ConvertirTemperatura(Minput);

					int respuesta = 0;
					respuesta = JOptionPane.showConfirmDialog(null, "¿Desea continuar?");
					if ((respuesta == 0) && (ValidarNumero.ValidarNumero(input) == true)) {
					
					} else {
						JOptionPane.showMessageDialog(null, "Programa terminado");
						System.exit(0);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Valor inválido");
				}
				
			}

		});

		opcion3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Que pena!, saliendo del programa ...");
				System.exit(0);

			}
		});
	}

	

	
}
class fondoPanel extends JPanel{
	
	private Image imagen;
	
	@Override
	public void paint(Graphics g) {
		
		imagen = new ImageIcon(getClass().getResource("/imagenes/monedas.png")).getImage();
		
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
		
	
	}
}	
