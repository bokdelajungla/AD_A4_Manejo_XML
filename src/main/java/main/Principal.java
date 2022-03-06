package main;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Principal {

	public static void main(String[] args) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador;
		Document doc;
		
		try {
			analizador = fabrica.newDocumentBuilder();
			doc = analizador.newDocument();
			Element concierto = doc.createElement("concierto");
			Element fecha = doc.createElement("fecha");
			Element hora = doc.createElement("hora");
			Element participantes = doc.createElement("participantes");
			doc.appendChild(concierto);
			concierto.appendChild(fecha);
			concierto.appendChild(hora);
			concierto.appendChild(participantes);
			fecha.appendChild(doc.createTextNode("20-oct-2018"));
			hora.appendChild(doc.createTextNode("21:15"));
			agregarParticipantes(participantes, doc);
			guardar(doc);
			
			System.out.println("fichero XML creado con exito");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	private static void agregarParticipantes(Element participantes, Document doc) {
		Element participante = doc.createElement("participante");
		participantes.appendChild(participante);
		Element entrada = doc.createElement("entrada");
		entrada.appendChild(doc.createTextNode("21:30"));
		participante.appendChild(entrada);
		Element grupo = doc.createElement("grupo");
		grupo.appendChild(doc.createTextNode("Las Ardillas de Dakota"));
		participante.appendChild(grupo);
		
		participante = doc.createElement("alumno");
		participantes.appendChild(participante);
		entrada = doc.createElement("entrada");
		entrada.appendChild(doc.createTextNode("22:15"));
		participante.appendChild(entrada);
		grupo = doc.createElement("nota");
		grupo.appendChild(doc.createTextNode("Fito y Fitipaldis"));
		participante.appendChild(grupo);
		
		participante = doc.createElement("alumno");
		participantes.appendChild(participante);
		entrada = doc.createElement("entrada");
		entrada.appendChild(doc.createTextNode("23:00"));
		participante.appendChild(entrada);
		grupo = doc.createElement("grupo");
		grupo.appendChild(doc.createTextNode("Coldplay"));
		participante.appendChild(grupo);
	}
	
	private static void guardar(Document doc) throws TransformerException {
		TransformerFactory fabricaConversor = TransformerFactory.newInstance();
		Transformer conversor = fabricaConversor.newTransformer();
		DOMSource fuente = new DOMSource(doc); 
		StreamResult resultado = new StreamResult(new File("concierto.xml"));
		conversor.transform(fuente, resultado);
	}

}
