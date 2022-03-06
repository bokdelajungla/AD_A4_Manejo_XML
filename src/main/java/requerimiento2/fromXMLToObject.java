package requerimiento2;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import entidad.Cartelera;
import entidad.Pelicula;


public class fromXMLToObject {
	
	public static void main(String[] args) {
		try {
			JAXBContext contexto = JAXBContext.newInstance(Cartelera.class);
			//Esta vez creamos un objeto que nos permite pasar
			//de XML a Object, es decir deserializar
			Unmarshaller u = contexto.createUnmarshaller();
			File fichero = new File("Cartelera.xml");
			if (fichero.exists()) {
				Cartelera c = (Cartelera) u.unmarshal(fichero);
				System.out.println("Cine: " + c.getNombreCine() + " en " + c.getCiudad());
				System.out.println("Con las peliculas: ");
				for(Pelicula pelicula: c.getPeliculas()) {
					System.out.println("Director: " + pelicula.getDirector() + 
									   ". Nombre: " + pelicula.getNombre() +
										". Edad recomendada: " + pelicula.getEdadRecomendada());
				}
			} else {
				System.out.println("Fichero XML Cartelera.xml no encontrado");
			}

		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}
	}
}
