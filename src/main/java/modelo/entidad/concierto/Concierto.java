package modelo.entidad.concierto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//Estas anotaciones sirven para que JAXB que es el motor de java para
//convertir objetos a XML y a la inversa, sepa como hacerlo
//serializar y deserializar

//esta etiqueta estamos estableciendo el nombre de el nodo raiz en xml
//etiqueta obligatoria
@XmlRootElement(name="concierto")
//Podemos hacer que las etiquetas salgan en un determinado orden
//etiqueta opcional
@XmlType(propOrder = {
		"fecha",
	    "hora",
	    "listaParticipantes"
	})
public class Concierto {
	
	private String fecha;
	private String hora;
	private List<Participante> listaParticipantes;
	
	public Concierto() {
		super();
		listaParticipantes = new ArrayList<Participante>();
	}
	
	//toString()	
	@Override
	public String toString() {
		return "Concierto [fecha=" + fecha + ", hora=" + hora + ", listaParticipantes=" + listaParticipantes + "]";
	}
	//GETTERS & SETTERS
	//Establezco que cada elemento del array se serialice a una etiqueta xml cuyo nombre
	//sea "participante"
	@XmlElement(name = "participante")
	//Podemos crear una etiqueta que envuelva las etiquetas participantes, si no la ponemos saldran
	//las etiquetas "participantes" al mismo nivel que concierto, de esta manera agrupamos todos
	//los particpantes en la etiqueta "participantes"
	@XmlElementWrapper(name = "participantes")
	public List<Participante> getListaParticipantes() {
		return listaParticipantes;
	}
	public void setListaParticipantes(List<Participante> listaParticipantes) {
		this.listaParticipantes = listaParticipantes;
	}
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
}
