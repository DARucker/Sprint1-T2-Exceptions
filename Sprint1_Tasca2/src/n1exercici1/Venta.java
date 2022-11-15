package n1exercici1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Venta {

	private List<Producto> productos = new ArrayList<>();
	private double precioTotal;
	public static Scanner teclado;
	
	Producto p = new Producto();

	public void cargarDatosFactura() {

		
		int continua = 1;
		
		while (continua  == 1) {

			teclado = new Scanner(System.in);
			p.setNombre(capturarString());
			p.setPrecio(capturarNumero("Ingrese precio: "));
			System.out.println("");
			productos.add(p);
			
			continua = capturarNumero("presione 1 si desea cargar otro item");
		}
		
		calcularTotal();
	}

	public void calcularTotal() {
		
		double total = 0;
		
		for (Producto producto : productos) {
			total = total + producto.getPrecio();
		}

		System.out.println("Total: " + total);
	}
	
	
	public static String capturarString () {
		teclado = new Scanner(System.in);
		String productoFactura;
		System.out.println("Ingrese producto");
		System.out.println("");
		productoFactura = teclado.nextLine();

		return productoFactura;

	}

	public static int capturarNumero(String mensaje) {
				
		int datoNumerico = 0;
		System.out.println(mensaje);
		System.out.println(" ");
		//return Integer.parseInt(teclado.nextLine());
		datoNumerico = teclado.nextInt();
		return datoNumerico;
	
	}





}