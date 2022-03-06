package requerimiento2.jorge;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import modelo.entidad.concierto.Concierto;
import modelo.entidad.concierto.Participante;

public class LecturaXML_JAXB_Concierto {

	public static void main(String[] args) {
		try {
			JAXBContext contexto = JAXBContext.newInstance(Concierto.class);
			//Esta vez creamos un objeto que nos permite pasar
			//de XML a Object, es decir deserializar
			Unmarshaller u = contexto.createUnmarshaller();
			File fichero = new File("concierto_jaxb.xml");
			if (fichero.exists()) {
				Concierto concierto = (Concierto) u.unmarshal(fichero); //Hacemos un cast a Concierto
				System.out.println("Fecha y hora del concierto: " + concierto.getFecha() + " " + concierto.getHora());
				System.out.println("Participan los siguientes grupos:");
				for(Participante p: concierto.getListaParticipantes()) {
					System.out.println(" " + p.getEntrada() + 
									   " " + p.getNombre());
				}
			} else {
				System.out.println("Fichero XML concierto_jaxb.xml no encontrado");
				System.out.println("Ejecute primero \"Principal_JAXB\"");
			}

		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}
	}

}
