package n1exercici1;

public class VentaVaciaException extends Exception {

	public VentaVaciaException() {}
	
	public VentaVaciaException (String msj) {
		
		super(msj);
		
	}
	
	public String getMessage() {
		
		return "Para realizar una venta debes agregar productos.";
	}

}