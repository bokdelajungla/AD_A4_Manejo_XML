package requerimiento2;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import entidad.Cartelera;
import entidad.Pelicula;


public class FromObjectToXML {

	public static void main(String[] args) {
		
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(Cartelera.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			e.printStackTrace();			
			return;//Dejamos de ejecutar el metodo main
		}

		Marshaller m;
		try {
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Cartelera cartelera = new Cartelera();
			cartelera.setNombreCine("IDEAL");
			cartelera.setCiudad("Madrid");
			
			cartelera.getPeliculas().add(new Pelicula("Star Wars", "J.J Abrams", 13));
			cartelera.getPeliculas().add(new Pelicula("The Batman", "Matt Reeves", 13));
			cartelera.getPeliculas().add(new Pelicula("Shang-Chi", " Destin Daniel", 7));

			m.marshal(cartelera, new File("Cartelera.xml"));
			System.out.println("El archivo Cartelera.xml ha sido creado con exito,"
					+ " refresque su eclipse :)");
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			e.printStackTrace();
		}
	}
}

