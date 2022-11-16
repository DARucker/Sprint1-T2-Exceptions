package n1exercici1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Venta {

	List<Producto> productos = new ArrayList<>();
	private double precioTotal;
	public static Scanner teclado;
	Producto p;

	public int comienzaCargarFactura() throws VentaVaciaException {
		p = new Producto();
		teclado = new Scanner(System.in);
		p.setNombre(capturarString());

		if (p.getNombre().isEmpty()) {
			throw new VentaVaciaException("Para realizar una venta debes agregar productos.");
		}

		p.setPrecio(capturarNumero("Ingrese precio: "));
		System.out.println("");

		productos.add(0, p);

		int continua = capturarNumero("presione 1 si desea cargar otro item u otro numero para finalizar");

		if (continua > 1) {

			calcularTotal();
		}
		return continua;
	}

	public void cargarDatosFactura() {

		int continua = 1;

		while (continua == 1) {
			p = new Producto();
			teclado = new Scanner(System.in);
			p.setNombre(capturarString());
			p.setPrecio(capturarNumero("Ingrese precio: "));
			productos.add(p);

			continua = capturarNumero("presione 1 si desea cargar otro item u otro numero para finalizar");
		}

		calcularTotal();

	}

	public void calcularTotal() {

		double total = 0;

		/*
		 * Codigo Generado para cumplir con el ultimo parrafo de la tarea
		 */
		try {
			productos.add(-9, p);
		} catch (ArrayIndexOutOfBoundsException e1) {
			System.out.println(e1.getMessage() + " E1 Array: la posición elegida está fuera del arreglo");
		}catch (IndexOutOfBoundsException e2) {
			System.out.println("----------");
			System.err.println(e2.getMessage() + " Codigo Generado para cumplir con el último parrafo de la tarea");
			System.out.println("----------");
		}

		for (Producto prod : productos) {
			total = total + prod.getPrecio();
			System.out.println(prod.getNombre() + " " + prod.getPrecio());
		}

		System.out.println("Total: " + total);
	}

	public static String capturarString() {
		teclado = new Scanner(System.in);
		String productoFactura;
		System.out.println("Ingrese producto");
		productoFactura = teclado.nextLine();

		return productoFactura;

	}

	public static int capturarNumero(String mensaje) {
		Integer datoNumerico;

		do {

			System.out.println(mensaje);
			System.out.println(" ");

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