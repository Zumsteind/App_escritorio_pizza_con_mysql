package dominio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventanaprincipal extends JFrame {

	
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnmenuprincipal;
	private JMenuItem mntmAgregarPizza;
	private JMenuItem mntmListaDePizzas;
	
	
	
	public Ventanaprincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 599);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(128, 128, 128));
		setJMenuBar(menuBar);
		
		JMenu mnmenuprincipal = new JMenu("Menu Principal");
		menuBar.add(mnmenuprincipal);
		
		JMenuItem mntmAgregarPizza = new JMenuItem("Agregar pizza");
		mntmAgregarPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//accion del boton menu agregarpizza
				
				contentPane.removeAll();
				
				panelagregar panel =new panelagregar();
				
				panel.setBounds(0, 0, getWidth(), getHeight());
				
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
				
			}
		});
		mnmenuprincipal.add(mntmAgregarPizza);
		
		JMenuItem mntmListaDePizzas = new JMenuItem("Lista de pizzas");
		mntmListaDePizzas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//aca le da la funcionalidad el item menu listar
				
				contentPane.removeAll();
				panellistar panel = new panellistar();
				panel.setBounds(0, 0, getWidth(), getHeight());
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
				
			}
		});
		mnmenuprincipal.add(mntmListaDePizzas);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPizzeria = new JLabel("Pizzeria");
		lblPizzeria.setForeground(new Color(255, 215, 0));
		lblPizzeria.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPizzeria.setBounds(255, 83, 131, 43);
		contentPane.add(lblPizzeria);
		
		JLabel lblLodemickol = new JLabel("LoDe_Mickol");
		lblLodemickol.setForeground(Color.ORANGE);
		lblLodemickol.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblLodemickol.setBounds(206, 137, 203, 85);
		contentPane.add(lblLodemickol);
	}
}
