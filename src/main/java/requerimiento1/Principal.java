package requerimiento1;

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
import org.w3c.dom.Text;

public class Principal {

	public static void main(String[] args) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador;
		Document doc;
		
		try {
			analizador = fabrica.newDocumentBuilder();
			// Creamos nuevo documento vacio
			doc = analizador.newDocument();

			// A�adimos elemento raiz
			Element concierto = doc.createElement("concierto");
			doc.appendChild(concierto);
			Element fecha = doc.createElement("fecha");
			Text nodeFecha = doc.createTextNode("20-oct-2018");
			fecha.appendChild(nodeFecha);
			concierto.appendChild(fecha);
			Element hora = doc.createElement("hora");
			Text nodeHora = doc.createTextNode("21:30");
			hora.appendChild(nodeHora);
			concierto.appendChild(hora);
			Element participantes = doc.createElement("participantes");
			concierto.appendChild(participantes);
			
			// Agregamos los participantes
			agregarParticipantes(participantes, doc);
			
			// Guardamos en disco el nuevo documento XML.
			guardar(doc);
			System.out.println("El fichero se ha creado con éxito");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void agregarParticipantes(Element participantes, Document doc) {
		// Agregamos primer participante
		Element participante = doc.createElement("participante");
		participantes.appendChild(participante);
		//Añadir elemento de texto en 2 pasos

		Element entrada = doc.createElement("entrada");
		Text horaEntrada = doc.createTextNode("21:30");
		entrada.appendChild(horaEntrada);
		participante.appendChild(entrada);
		Element grupo = doc.createElement("grupo");
		//Añadir elemento de texto en 1 paso
		grupo.appendChild(doc.createTextNode("Las Ardillas de Dakota"));
		participante.appendChild(grupo);

		// Agregamos segundo participante
		participante = doc.createElement("participante");
		participantes.appendChild(participante);		
		entrada = doc.createElement("entrada");
		entrada.appendChild(doc.createTextNode("22:15"));
		participante.appendChild(entrada);
		grupo = doc.createElement("grupo");
		grupo.appendChild(doc.createTextNode("Fito y Fitipaldis"));
		participante.appendChild(grupo);

		
		// Agregamos tercer participante
		participante = doc.createElement("participante");
		participantes.appendChild(participante);		
		entrada = doc.createElement("entrada");
		entrada.appendChild(doc.createTextNode("23:00"));
		participante.appendChild(entrada);
		grupo = doc.createElement("grupo");
		grupo.appendChild(doc.createTextNode("ColdPlay"));
		participante.appendChild(grupo);
	}
	
	private static void guardar(Document doc) throws TransformerException {
		//fabrica de Transformes
		TransformerFactory fabricaConversor = TransformerFactory.newInstance();
		//creamos el objeto Transfomer, que nos permitira serializar el arbol
		//dom a un fichero
		Transformer conversor = fabricaConversor.newTransformer();
		//creamos la fuente de la cual sacaremos el arbol dom
		DOMSource fuente = new DOMSource(doc); 
		//Creamos el flujo de salida, al fichero que queremos
		StreamResult resultado = new StreamResult(new File("concierto.xml"));
		//por ultimo, serializamos los datos
		conversor.transform(fuente, resultado);
	}

}
