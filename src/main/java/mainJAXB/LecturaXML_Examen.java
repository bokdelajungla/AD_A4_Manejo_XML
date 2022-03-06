package mainJAXB;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import beans.Alumno;
import beans.Asignatura;
import beans.Examen;


public class LecturaXML_Examen {

	public static void main(String[] args) {
		try {
			JAXBContext contexto = JAXBContext.newInstance(Examen.class);
			Unmarshaller u = contexto.createUnmarshaller();
			File fichero = new File("examen.xml");
			if (fichero.exists()) {
				Examen e = (Examen) u.unmarshal(fichero);
				System.out.println("Examen del modulo " + e.getModulo());
				System.out.println("El " + e.getDia());
				System.out.println("Consta de las siguientes asignaturas: ");
				for(Asignatura a : e.getAsignaturas()) {
					System.out.println("\t" + a.getNombre());
					System.out.println("\tCon profesor " + a.getProfesor());
					System.out.println("\tRealiado a las " + a.getHora());
					System.out.println("\tPor los siguientes alumnos: ");
					for(Alumno al : a.getAlumnos()) {
						System.out.println("\t\t" + al.getNombre() + " con nota: " + al.getNota());
					}
				}
			} else {
				System.out.println("Fichero examen.xml no encontrado");
			}

		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}
	}

}
