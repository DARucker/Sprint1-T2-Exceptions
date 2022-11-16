package n1exercici1;

public class App {

	//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
	
	public static void main(String[] args) {
		
 
		int continua = 0;
		Venta v = new Venta();
		
		try {
		continua = v.comienzaCargarFactura();
		
		} catch (VentaVaciaException e) {

			System.out.println(e.getMessage());
			System.out.println("Programa finalizado");
		}		
		
		if(continua == 1) {
			v.cargarDatosFactura();
		}
	
	}

}

