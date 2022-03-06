package modelo.entidad.cartelera;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pelicula")
public class Pelicula {

		private String nombre;
		private String director;
		private int edadRecomendada;
		
		public Pelicula() {}

		public Pelicula(String nombre, String director, int edadRecomendada) {
			super();
			this.nombre = nombre;
			this.director = director;
			this.edadRecomendada = edadRecomendada;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDirector() {
			return director;
		}

		public void setDirector(String director) {
			this.director = director;
		}

		public int getEdadRecomendada() {
			return edadRecomendada;
		}

		public void setEdadRecomendada(int edadRecomendada) {
			this.edadRecomendada = edadRecomendada;
		}

		@Override
		public String toString() {
			return "Pelicula [nombre=" + nombre + ", director=" + director + ", edadRecomendada=" + edadRecomendada
					+ "]";
		}
}
