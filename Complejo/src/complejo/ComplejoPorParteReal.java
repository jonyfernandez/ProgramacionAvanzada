package complejo;

import java.util.Comparator;

public class ComplejoPorParteReal implements Comparator<Complejo> {

	@Override
	public int compare(Complejo uno, Complejo dos) {
		return uno.real.compareTo(dos.real);
	}

}
