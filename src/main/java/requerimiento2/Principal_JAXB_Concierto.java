package requerimiento2;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import modelo.entidad.concierto.Concierto;
import modelo.entidad.concierto.Participante;

public class Principal_JAXB_Concierto {

	public static void main(String[] args) {
		JAXBContext contexto;
		try {
			/*
			 * Obtiene el contexto asociado a la clase Concierto, con dicho
			 * contexto podremos convertir el objeto a un xml y a la inversa. 
			 * Provoca una excepción de tipo JAXBException si la clase Concierto 
			 * no cumple los requisitos para la conversión a XML, es decir, 
			 * contener las anotaciones necesarias y no cuenta con un constructor 
			 * sin argumentos.
			 */
			contexto = JAXBContext.newInstance(Concierto.class);//inyeccion de dependecia
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}

		Marshaller m;
		try {
			/*
			 * Obtiene el objeto Marshaller asociado al contexto.
			 * Con dicho objeto podremos convertir un objeto en xml
			 * es decir, lo serializaremos
			 */
			m = contexto.createMarshaller();
			/*
			 * Establecer la propiedad JAXB_FORMATTED_OUTPUT con el valor true 
			 * permite que en la conversión al formato XML se incluyan retornos 
			 * de carro e indentación.
			 */
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			//creamos el Concierto y los Participantes
			Concierto concierto = new Concierto();
			concierto.setFecha("20-oct-2018");
			concierto.setHora("21:30");
			
			concierto.getListaParticipantes().add(new Participante("21:30","Las Ardillas de Dakota"));
			concierto.getListaParticipantes().add(new Participante("22:15","Fito y Fitipaldis"));
			concierto.getListaParticipantes().add(new Participante("23:00","ColdPlay"));

			
			//Convertimos un objeto a xml y lo imprimimos por pantalla
			m.marshal(concierto, System.out);
			//tambien podemos crear un fichero
			m.marshal(concierto, new File("concierto_jaxb.xml"));
		} catch (JAXBException e) {
			System.out.println("Error convirtiendo el objeto a formato XML");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
}

