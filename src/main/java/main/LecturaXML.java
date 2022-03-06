package main;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LecturaXML {

	public static void main(String[] args) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador;
		Document dom;
		Node raiz;
		
		try {
			analizador = fabrica.newDocumentBuilder();
			dom = analizador.parse("concierto.xml");
			raiz = dom.getDocumentElement();
			recorrerNodos(raiz);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/* LECTURA CON TABULACIONES :
	 
	 public static void recorrerNodos(Node raiz) {
		NodeList nodos = raiz.getChildNodes();
		// Contamos los impares ya que los pares corresponden a nodos de tabulacion
		System.out.println("Fecha y hora del concierto: " + nodos.item(1).getTextContent() + " " + nodos.item(3).getTextContent());
		recorrerParticipantes(nodos.item(5));
	}
	 
	 */
	
	public static void recorrerNodos(Node raiz) {
		NodeList nodos = raiz.getChildNodes();
		// Contamos los impares ya que los pares corresponden a nodos de tabulacion
		System.out.println("Fecha y hora del concierto: " + nodos.item(0).getTextContent() + " " + nodos.item(1).getTextContent());
		recorrerParticipantes(nodos.item(2));
	}
	
	/* LECTURA CON TABULACIONES :
	 
	 public static void recorrerParticipantes(Node participantes) {
		NodeList nodos = participantes.getChildNodes();
		System.out.println("Participan los siguientes grupos: ");
		for (int i=0; i<nodos.getLength();i++) {
			Node nodoHijo = nodos.item(i);
			if (nodoHijo.getNodeType() == Node.ELEMENT_NODE) {
				System.out.println("\t" + nodoHijo.getChildNodes().item(1).getTextContent() + " " + nodoHijo.getChildNodes().item(3).getTextContent());
			}
		}
	}
	 
	 */
	
	public static void recorrerParticipantes(Node participantes) {
		NodeList nodos = participantes.getChildNodes();
		System.out.println("Participan los siguientes grupos: ");
		for (int i=0; i<nodos.getLength();i++) {
			Node nodoHijo = nodos.item(i);
			if (nodoHijo.getNodeType() == Node.ELEMENT_NODE) {
				System.out.println("\t" + nodoHijo.getChildNodes().item(0).getTextContent() + " " + nodoHijo.getChildNodes().item(1).getTextContent());
			}
		}
	}

}
