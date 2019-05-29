package complejo;

import java.util.Comparator;

public class ComplejoPorParteImaginaria implements Comparator<Complejo> {

	@Override
	public int compare(Complejo uno, Complejo dos) {
		return uno.imaginario.compareTo(dos.imaginario);
	}
}
