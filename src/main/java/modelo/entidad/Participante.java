package modelo.entidad;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="participante")
@XmlType(propOrder = {
		"entrada",
	    "nombre"
	})
public class Participante {
	
	private String entrada;
	private String nombre;
	
	public Participante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Participante(String entrada, String nombre) {
		super();
		this.entrada = entrada;
		this.nombre = nombre;
	}

	
	//toString()
	@Override
	public String toString() {
		return "Participante [entrada=" + entrada + ", nombre=" + nombre + "]";
	}

	//GETTERS & SETTERS
	public String getEntrada() {
		return entrada;
	}
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	

}
