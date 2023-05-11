package dominio;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panellistar extends JPanel {

	private JList list;
	private static DefaultListModel<pizza> model;
	private JTextField txtbuscar;
	/**
	 * Create the panel.
	 */
	public panellistar() {
		setBackground(new Color(143, 188, 143));
		setLayout(null);
		
		JLabel lblNuestraVariedadDe = new JLabel("Nuestra variedad de pizzas");
		lblNuestraVariedadDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNuestraVariedadDe.setBounds(195, 33, 230, 45);
		add(lblNuestraVariedadDe);
		
		JList list = new JList();
		list.setBounds(129, 115, 367, 164);
		
		pizzadao dato = new pizzadao();
		pizza pizza = new pizza();
		DefaultListModel<pizza> model=new DefaultListModel<pizza>();
		ArrayList<pizza> listapizza= dato.listarpizzas();
		
		for (pizza pizza2 : listapizza) {
			model.addElement(pizza2);
		}
		list.setModel(model);
		
		add(list);
		
		txtbuscar = new JTextField();
		txtbuscar.setBounds(132, 78, 222, 20);
		add(txtbuscar);
		txtbuscar.setColumns(10);
		txtbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				model.clear();
				pizzadao dato = new pizzadao();
				pizza pizza = new pizza();
				ArrayList<pizza> listapizza= dato.mostrarpizzaspornombre(txtbuscar.getText());
				
				for (pizza pizza2 : listapizza) {
					model.addElement(pizza2);
				}
				add(list);
				
			}
		});
		
		
		JButton btnBuscar = new JButton("buscar");
		btnBuscar.setBounds(364, 77, 89, 23);
		add(btnBuscar);

	}
}
