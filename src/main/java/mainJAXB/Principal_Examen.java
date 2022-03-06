package mainJAXB;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import beans.Alumno;
import beans.Asignatura;
import beans.Examen;

public class Principal_Examen {

	public static void main(String[] args) {
		
		JAXBContext contexto;
		
		try {
			contexto = JAXBContext.newInstance(Examen.class);
			
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}
		
		Marshaller m;
		try {
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			List<Alumno> lalum = new ArrayList<Alumno>();
			lalum.add(new Alumno("Antonio", 10.0));
			lalum.add(new Alumno("Jorge", 10.0));
			lalum.add(new Alumno("Adrian", 10.0));

			Asignatura a1 = new Asignatura("10:00", "Acceso a Datos", "Félix", lalum);
			Asignatura a2 = new Asignatura("12:15", "Empresa", "Alfredo", lalum);
			Asignatura a3 = new Asignatura("16:00", "Multimedia", "Raquel", lalum);
			List<Asignatura> lasig = new ArrayList<Asignatura>();
			lasig.add(a1);
			lasig.add(a2);
			lasig.add(a3);
			
			Examen e = new Examen("16-mar-2022", "DAM", lasig);
			
			m.marshal(e, new File("examen.xml"));
			System.out.println("Se ha generado el siguiente fichero:");
			m.marshal(e, System.out);
			
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
