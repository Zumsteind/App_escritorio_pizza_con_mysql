package dominio;

public class pizza {
private int id;
private String nombre;


public pizza() {
	
}




public pizza(int id, String nombre) {

	this.id = id;
	this.nombre = nombre;
}

@Override
public String toString() {
	return "PIZZA ID: " + id + " - SABOR: " + nombre;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}


	
	
}
