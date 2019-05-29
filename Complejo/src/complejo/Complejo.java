package complejo;

import java.util.Arrays;

import org.junit.Assert;

public class Complejo implements Comparable<Complejo>{
	
	Double real;
	Double imaginario;
	
	//EN JAVA NO SE PUEDE SOBRECARGAR OPERADORES Y TAMPOCO NO HAY DESTRUCTORES.

	//CONSTRUCTORES
	
	///Sobrecargar, varias funciones con el mismo nombre pero con distintos paramatros.
	///Sobreescribir, la estoy pisando.
	
	///SI DEFINO UN CONSTRUCTOR, EL POR DEFECTO DEJA DE FUNCIONAR.
	public Complejo(double real,double imag) { //CONTRUCTOR PARA INICIALIZAR VALORES Y AHI ES DONDE SE INSTANCIA EL OBJETO.
		this.real = real; //this hace referencia a lo suyo.
		this.imaginario = imag;
	}
	
	public Complejo(){ 
		this(0,0);
	}
	
	public String toString(){ ///CONVIERTE AL OBJETO LLAMADOR EN UN STRING.
		return "("+this.real+","+this.imaginario+")";
	}
	
	public Complejo sumar(Complejo obj){
		
		return new Complejo(this.real + obj.real, this.imaginario + obj.imaginario);
		/*Complejo result = new Complejo();
		result.real += obj.real;
		result.imaginario += obj.imaginario;
		return result;*/
	}
	
	public Complejo resta(Complejo obj){
		
		return new Complejo(this.real - obj.real, this.imaginario - obj.imaginario);
		/*Complejo result = new Complejo();
		result.real -= obj.real;
		result.imaginario -= obj.imaginario;
		return result;*/
	}
	
	public Complejo multiplicar(Complejo c){
		return new Complejo(this.real * c.real - this.imaginario * c.imaginario, this.real * c.imaginario + this.imaginario * c.real);
	}
	
	public Double modulo(){
		
		return Math.sqrt(this.real * this.real + this.imaginario * this.imaginario);
		///return Math.sqrt(Math.pow(this.real,2) * Math.pow(this.real,2));
	}
	
	public Complejo clone(){
		
		return new Complejo(this.real,this.imaginario);
		
	}
	
	public Complejo sumarEscalar(double escalar){
		return new Complejo(this.real + escalar,this.imaginario);
	}
	
	///Si dos objetos son iguales siempre dan lo mismo HashCode.

	@Override
	public int hashCode() { ///Devuelve un Entero que representa de forma espacial mi Objeto ///Donde está ubicado el objeto.
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(imaginario);
		result = prime * result + (int) (temp ^ (temp >>> 32)); ///"^" bit , "temp >>> 32" Desplazamiento a derecha/ Se trabaja con los bits.
		temp = Double.doubleToLongBits(real);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) { //SI CAMBIO A OBJECT POR COMPLEJO Y SACO EL @ SE ESTARIA GENERADO UNA SOBRECARGA DE FUNCIONES.
		if (this == obj) //COMPARO LAS REFERENCIAS.
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) //GETCLASS() DEVUELVE LA CLASE A LA CUAL ES REFERENCIADO.
			return false;
		Complejo other = (Complejo) obj; //SE CASTEA obj A COMPLEJO. SE REFERENCIA DE OBJETO A COMPLEJO
		if (Double.doubleToLongBits(imaginario) != Double.doubleToLongBits(other.imaginario)) /// COMPARO LOS DOUBLE. TOMA TODOS LOS DECIMALES.
			return false;
		if (Double.doubleToLongBits(real) != Double.doubleToLongBits(other.real))
			return false;
		return true;
	}
	
	
	@Override
	public int compareTo(Complejo o){
		
		///return (int)(this.modulo() - (o.modulo())); //Lo puedo hacer así
		
		return this.modulo().compareTo(o.modulo()); ///Lo puedo hacer así
		//SI PONGO -THIS LO ORDENO DE FORMA DESCANDENTE
		
		/*if(this.modulo() > o.modulo()) // O lo puedo hacer así.
			return 1;
		if(this.modulo() < o.modulo())
			return -1;
		
		return 0;*/	
		
	}
	
	public void queOrdena(Complejo vec[]){
		Complejo[] vector ={
			new Complejo(21,32),new Complejo(5,2),new Complejo(1,-6)	
		};
		
		Complejo[] vectorOrdenado ={
				new Complejo(1,-6) ,new Complejo(5,2),new Complejo(21,32)
			};
		
		Arrays.sort(vector);
		Assert.assertArrayEquals(vectorOrdenado, vector);
	}
	
}
