package figura;

public class CalculadoraDePintura {
	
	private static final double LITROS_POR_UNIDAD = 0.25;
	
	public static double pinturaPara(Figura figura){
		
		return figura.area() * LITROS_POR_UNIDAD;
		
	}

}
