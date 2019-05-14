package entrenamiento;

import java.util.ArrayList;
import java.util.List;

/*Los Laboratorios Bell de EE.UU. encargaron a Michael Lesk desarrollar un sistema para ubicar telef�nicamente 
a las personas que estaban vinculadas con ellos. Lo que se hizo fue lo siguiente: 
Como en el tel�fono se tienen los n�meros 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 y los s�mbolos * y #, 
se puede asignar a cada uno las letras del alfabeto de la siguiente manera:

2 ---------- A, B, C 

3 ---------- D, E, F 

4 ---------- G, H, I 

5 ---------- J, K, L 

6 ---------- M, N, �, O 

7 ---------- P, Q, R, S 

8 ---------- T, U, V 

9 ---------- W, X, Y, Z 
reservando el 0 para llamar a la operadora. Para llamar a G�mez, Juan se debe marcar el c�digo:

4 6 6 3 9 * 5 *

(El s�mbolo * denota que ha terminado el apellido y lo que sigue indica la inicial del nombre)

Puede pasar que a dos personas distintas les corresponda el mismo c�digo. Sin embargo, Michael Lesk, determin� que esto sucede en s�lo el 0,2% de los casos.

Suponiendo que alguien se toma el trabajo de cargar la gu�a telef�nica de una ciudad determinada, 
escribir un programa que al entrar el c�digo correspondiente al apellido seguido de la inicial del primer nombre:

***d� el tel�fono de la persona en el caso de que haya una �nica persona con ese c�digo
***cuando haya dos personas distintas con el mismo c�digo, emita un mensaje apropiado de manera de pedir m�s informaci�n para determinar el n�mero telef�nico buscado.
 */


public class Ejercicio6 {
	
	public static void main(String[] args) {
		
		List<Persona> guiaTelefonica = new ArrayList<Persona>();
		Persona p1 = new Persona("Fernandez", "Jonathan", 12345678);
		//Persona p2 = new Persona("Fernandez", "Jose", 12345677);
		guiaTelefonica.add(p1);
		//guiaTelefonica.add(p2);
		String codigoABuscar = "337626339*5*";
		Persona resultado = null;
		int cantidad = 0;
			
		//System.out.println(darTelefono(codigoABuscar, guiaTelefonica));
		
		for(Persona persona : guiaTelefonica){
			if(darTelefono(codigoABuscar, persona)){
				resultado = persona;
				cantidad++;
			}
		}
		
		if(cantidad == 0)
			System.out.println("No existe el contacto en la guia");
		else if(cantidad == 1) System.out.println("El telefono es : "+resultado.getTelefono());	
		else System.out.println("Hay mas de dos contactos con el mismo codigo, debe proporcionar mas informacion");
	}
	
	public static boolean darTelefono(String codigo, /*List<Persona> guia*/ Persona persona ){
		
		/*for(Persona persona : guia)
			if(codigo.equals(generarCodigo(persona))){
				return persona.getTelefono();
			}
		return 0;*/
		
		if(codigo.equals(generarCodigo(persona))){
			return true;
		}
		
		return false;
	}
	
	public static String generarCodigo(Persona persona){
		
		String codigo = (persona.getApellido()+"*"+persona.getNombre().charAt(0)).toUpperCase();
		codigo = codigo.replaceAll("[A|B|C]", "2").replaceAll("[D|E|F]", "3").replaceAll("[G|H|I]", "4").replaceAll("[J|K|L]", "5");
		codigo = codigo.replaceAll("[M|N|�|O]", "6").replaceAll("[P|Q|R|S]", "7").replaceAll("[T|U|V]", "8").replaceAll("[W|X|Y|Z]", "9");
		return codigo+"*";
	}
	
}
