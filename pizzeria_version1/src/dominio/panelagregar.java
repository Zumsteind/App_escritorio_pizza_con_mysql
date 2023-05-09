package dominio;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panelagregar extends JPanel {
	
	private JTextField txtnombre;
	private JButton btnAgregar;
	 

	/**
	 * Create the panel.
	 */
	public panelagregar() {
		setBackground(new Color(51, 153, 51));
		setLayout(null);
		
		JLabel lblMenuAgregarPizza = new JLabel("MENU AGREGAR PIZZA");
		lblMenuAgregarPizza.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblMenuAgregarPizza.setBounds(145, 39, 227, 37);
		add(lblMenuAgregarPizza);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNombre.setBounds(46, 113, 79, 30);
		add(lblNombre);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(145, 121, 120, 22);
		add(txtnombre);
		txtnombre.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int fila=0;
				pizza x = new pizza();
				x.setNombre(txtnombre.getText());
				
				pizzadao dato= new pizzadao();
				fila=dato.agregarpizza(x);
				
				if(fila==1) {
					JOptionPane.showMessageDialog(null, "Pizza agregada con exito.");
				}else {JOptionPane.showMessageDialog(null, "pizza NO se pudo agregar.");}
				
			}
		});
		btnAgregar.setBounds(312, 120, 89, 23);
		add(btnAgregar);

	}
}
