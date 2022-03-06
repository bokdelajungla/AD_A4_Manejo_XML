package modelo.entidad.cartelera;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cartelera")
public class Cartelera {
	
	private String nombreCine;
	private String ciudad;
	private List<Pelicula> peliculas;

	public Cartelera() {
		peliculas = new ArrayList<Pelicula>();
	}
	
	@XmlElement(name = "pelicula")
	//Podemos crear una etiqueta que envuelva las etiquetas persona, si no la ponemos saldran
	//las etiquetas "persona" al mismo nivel que la familia, de esta manera agrupamos todos
	//los "miembro" en la etiqueta "miembros"
	@XmlElementWrapper(name = "peliculas")
	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public String getNombreCine() {
		return nombreCine;
	}

	public void setNombreCine(String nombreCine) {
		this.nombreCine = nombreCine;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	@Override
	public String toString() {
		return "Cartelera [nombreCine=" + nombreCine + ", ciudad=" + ciudad + ", peliculas=" + peliculas + "]";
	}
	
}
