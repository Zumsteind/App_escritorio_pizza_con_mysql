package dominio;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

import java.sql.*;

public class pizzadao {
	
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String dbname="dbpizzeriaversion1";
	private String user="root";
	private String pass="ROOT";
	
	public int agregarpizza(pizza pizza) 
	{
		String query= "INSERT INTO pizza (nombre) VALUES ('"+pizza.getNombre()+"')";
		int filas=0;
		
		Connection cn=null;
		
		try {
			
			cn=DriverManager.getConnection(host+dbname,user,pass);
			Statement st=cn.createStatement();
			filas=st.executeUpdate(query);
			
		
			
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null,"no se pudo acceder a la base de dato");
		}
		
		return filas;
		
	}
	
	public ArrayList<pizza> listarpizzas() {
		
		ArrayList<pizza> listapizza= new ArrayList<pizza>();
		
		Connection cn = null;
		
		try {
			cn=DriverManager.getConnection(host+dbname,user,pass);
			Statement st=  cn.createStatement();
					String query="select * from pizza";
		ResultSet rs=	st.executeQuery(query);
		
		while(rs.next()) {
			pizza x = new pizza();
			x.setNombre(rs.getString("nombre"));
			x.setId(rs.getInt("idpizza"));
			listapizza.add(x);
			
		}
		
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo acceder a la base de dato.");
		}
		
		return listapizza;
	}
	
	
	//devuelve un objeto pizza, pasandole por parametro un id; 
	public pizza obtenerpizzaid(int id) {
		
		
		pizza x = new pizza();
		Connection cn=null;
		try {
			
			cn=DriverManager.getConnection(host+dbname,user,pass);
			String query="select * from pizza where idpizza=?";
			PreparedStatement pst= cn.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			rs.next();
			
			x.setNombre(rs.getString("nombre"));
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return x;
	}
	
	public ArrayList<pizza>  mostrarpizzaspornombre(String nombre) {
		ArrayList<pizza> listapizza= new ArrayList<pizza>();
		
		
		Connection cn=null;
		
		
		try {
			
			cn=DriverManager.getConnection(host+dbname,user,pass);
				CallableStatement cst=	cn.prepareCall("call mostrarpizzapornombre(?)");
				cst.setString(1, nombre);
				ResultSet rs= cst.executeQuery();
				
				while (rs.next()) {
					
					pizza x = new pizza();
					x.setId(rs.getInt("idpizza"));
					x.setNombre(rs.getString("nombre"));
					
					listapizza.add(x);
					
				}
				rs.close();
		        cst.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "error en mostrar store procedure");
		}
		return listapizza;
		
	}
	
	
	

}
