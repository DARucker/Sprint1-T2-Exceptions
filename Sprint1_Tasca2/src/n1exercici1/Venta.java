package n1exercici1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Venta {

	private List<Producto> productos = new ArrayList<>();
	private Scanner teclado;
	private Producto p;

	// Metodo que tiene por objeto no permitir que se cargue una factura vacia
	
	public int comienzaCargarFactura() throws VentaVaciaException {
		p = new Producto();
		p.setNombre(capturarString("Ingrese el primer producto de la factura: "));
		if (p.getNombre().isEmpty()) {
			throw new VentaVaciaException("Para realizar una venta debes agregar productos.");
		}
		p.setPrecio(capturarNumero("Ingrese precio: "));
		productos.add(0, p);

		int continua = capturarNumero("presione 1 si desea cargar otro item u otro numero para finalizar");
		if (continua > 1) {
			calcularTotal();
		}
		return continua;
	}

	// Metodo que llama a los metodos que piden datos y acumula en el array
	
	public void cargarDatosFactura() {

		int continua = 1;

		while (continua == 1) {
			p = new Producto();
			p.setNombre(capturarString("Ingrese el producto: "));
			p.setPrecio(capturarNumero("Ingrese precio: "));
			productos.add(p);

			continua = capturarNumero("presione 1 si desea cargar otro item u otro numero para finalizar");
		}

		calcularTotal();

	}

	// Calcula, imprime y finaliza la ejecucion
	
	public void calcularTotal() throws ArrayIndexOutOfBoundsException {

		double total = 0;

		try {
		for (int i=0; i< productos.size(); i++) { // si el for llegara hasta "<=" arrojaria la excepcion que solicita el enunciado.
			total = total + productos.get(i).getPrecio();
			System.out.println(productos.get(i).getNombre() + " " + productos.get(i).getPrecio());
		}
		System.out.println("Total: " + total);
		}
		catch (IndexOutOfBoundsException e){
			System.err.println("La cantidad de productos sumados no coincide");
		}
	}

	// Metodos auxiliares para el ingreso de datos numericos y alfanumericos por teclado
	
	public  String capturarString(String mensaje) {
		teclado = new Scanner(System.in);
		System.out.println(mensaje);
		return teclado.nextLine();
	}

	public int capturarNumero(String mensaje) {
		Integer datoNumerico;

		do {
			System.out.println(mensaje);
			try {
				datoNumerico = Integer.parseInt(teclado.nextLine());
			} catch (Exception e) {
				System.out.println("El valor ingresado no es un numero. Intente nuevamente ");
				datoNumerico = -1;
			}

		} while (datoNumerico == -1);
		return datoNumerico;
	}

}