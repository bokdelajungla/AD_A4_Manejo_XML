package modelo.entidad.examen;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//nodo raiz
@XmlRootElement(name="asignatura")
//orden de las etiquetas
@XmlType(propOrder = {
		"nombre",
	    "hora",
	    "profesor",
	    "alumnos"
	})
/**
* Clase que emula un examen de segundo de DAM
* @author grupo 14 AD
* @version 1.0
*/
public class Asignatura {
	/**
	 * Hora del examen
	 */
	private String hora;
	/**
	 * Nombre de la asgignatura
	 */
	private String nombre;
	/**
	 * Nombre del profesor de la asignatura
	 */
	private String profesor;
	/**
	 * Alumnos que van a realizar dicho examen
	 */
	private List<Alumno> alumnos;
	
	// NECESARIO PONER EL CONSTRUCTOR SIN ARGUMENTOS AL TRABAJAR CON JAXB
	public Asignatura() {
		alumnos = new ArrayList<Alumno>();
	}
	
	// Constructor con parámetros, es el que vamos a usar dentro del main
	public Asignatura(String hora, String nombre, String profesor, List<Alumno> alumnos) {
		this.hora = hora;
		this.nombre = nombre;
		this.profesor = profesor;
		this.alumnos = alumnos;
	}
	
	// Getters & Setters (solo comentados los que se usan durante la práctica)
	
	/**
	 * Método que devuelve la hora de realización del examen
	 * @return hora del examen
	 */
	public String getHora() {
		return hora;
	}
	public void setHora(String fecha) {
		this.hora = fecha;
	}
	
	/**
	 * Método que devuelve el nombre del profesor
	 * @return nombre del profesor de la asignatura
	 */
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	
	/**
	 * método que devuelve el nombre de la asignatura para la cual se realizará el examen
	 * @return nombre de la asignatura
	 */
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//Vamos a agrupar cada elemento alumno en un nodo alumnos para una mayor claridad
	
	@XmlElement(name="alumno")
	@XmlElementWrapper(name="alumnos")
	/**
	 * Método que devuelve la lista de alumnos que realizarán el examen
	 * @return lista con los alumnos que van a realizar el examen
	 */
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	
}





