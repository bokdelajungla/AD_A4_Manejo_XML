package modelo.entidad;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="cliente")
@XmlType(propOrder = {
		"nombre",
	    "DNI"
	})
public class Cliente {
	
	private String nombre;
	private String DNI;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cliente(String nombre, String dNI) {
		super();
		this.nombre = nombre;
		DNI = dNI;
	}
	
	//toString()
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", DNI=" + DNI + "]";
	}
	
	//GETTERS &SETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	
	
	
}
