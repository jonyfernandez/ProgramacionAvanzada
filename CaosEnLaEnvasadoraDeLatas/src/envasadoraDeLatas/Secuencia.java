package envasadoraDeLatas;

public class Secuencia {
	
	private int posInicial;
	private int posFinal;
	private int longitud;
	
	public Secuencia(int posInicial, int posFinal, int longitud){
		this.posInicial = posInicial;
		this.posFinal = posFinal;
		this.longitud = longitud;
	}

	public int getPosInicial() {
		return posInicial;
	}

	
	public int getPosFinal() {
		return posFinal;
	}

	public int getLongitud() {
		return longitud;
	}
	
}
