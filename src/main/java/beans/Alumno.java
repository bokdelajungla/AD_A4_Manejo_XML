package beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="alumno")
/**
 * clase que simula un alumno de FP de DAW listo para realizar sus exámenes
 * @author grupo 14 AD
 * @version 1.0
 */
public class Alumno {
	/**
	 * Nombre del alumno
	 */
	private String nombre;
	/**
	 * Nota que va a sacar dicho alumno
	 */
	private double nota;
	
	// NECESARIO PONER EL CONSTRUCTOR SIN ARGUMENTOS AL TRABAJAR CON JAXB
	public Alumno() {
		
	}
	
	// Constructor con parámetros, es el que vamos a usar dentro del main
	public Alumno(String nombre, double nota) {
		this.nombre = nombre;
		this.nota = nota;
	}

	// Getters & Setters (solo comentados los que se usan durante la práctica)
	
	/**
	 * Devuelve el nombre del alumno que realizará el examen
	 * @return nombre del alumno
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve la calificación del alumno en el examen
	 * @return calificación del alumno
	 */
	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
}




