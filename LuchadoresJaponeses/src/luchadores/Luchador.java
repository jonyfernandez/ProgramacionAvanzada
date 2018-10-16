package luchadores;

public class Luchador {
	
	private int peso;
	private int altura;
	
	public Luchador(int peso, int altura) {
		this.peso = peso;
		this.altura = altura;
	}
	
	public boolean domina(Luchador rival) {
		
		if(this.peso > rival.peso && this.altura > rival.altura)
			return true;
		if(this.peso == rival.peso && this.altura > rival.altura || this.altura == rival.altura && this.peso > rival.peso)
			return true;
		
		return false;
		
	}

	@Override
	public String toString() {
		return "Luchador [peso=" + peso + ", altura=" + altura + "]";
	}

}
