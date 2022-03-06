package modelo.entidad.examen;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// nodo raiz
@XmlRootElement(name="examen")
// orden de las etiquetas
@XmlType(propOrder = {
		"modulo",
	    "dia",
	    "asignaturas"
	})
/**
 * Clase que emula un examen de segundo de DAM
 * @author grupo 14 AD
 * @version 1.0
 */
public class Examen {
	/**
	 * Fecha y hora del examen
	 */
	private String dia;
	/**
	 * Nombre de la asgignatura
	 */
	private String modulo;
	/**
	 * Alumnos que van a realizar dicho examen
	 */
	private List<Asignatura> asignaturas;
	
	// NECESARIO PONER EL CONSTRUCTOR SIN ARGUMENTOS AL TRABAJAR CON JAXB
	public Examen() {
		asignaturas = new ArrayList<Asignatura>();
	}
	
	// Constructor con parámetros, es el que vamos a usar dentro del main
	public Examen(String dia, String modulo, List<Asignatura> asignaturas) {
		this.dia = dia;
		this.modulo = modulo;
		this.asignaturas = asignaturas;
	}
	
	// Getters & Setters (solo comentados los que se usan durante la práctica)
	
	/**
	 * Método que devuelve la fecha de realización del examen
	 * @return fecha del examen
	 */
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	
	/**
	 * método que devuelve el nombre de la asignatura para la cual se realizará el examen
	 * @return nombre de la asignatura
	 */
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	
	//Vamos a agrupar cada elemento alumno en un nodo alumnos para una mayor claridad
	
	@XmlElement(name="asignatura")
	@XmlElementWrapper(name="asignaturas")
	/**
	 * Método que devuelve la lista de alumnos que realizarán el examen
	 * @return lista con los alumnos que van a realizar el examen
	 */
	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignatura(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	
}




