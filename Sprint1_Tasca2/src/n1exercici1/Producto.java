package n1exercici1;

public class Producto {

	private String Nombre;
	private double precio;
	
	public Producto() {
	}
	public Producto(String nombre, double precio) {
		Nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}