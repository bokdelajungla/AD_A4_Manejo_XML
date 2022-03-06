package requerimiento1;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class LecturaXML {
	
	public static void main(String[] args) {
		//Lo primero necesitamos una factoria que nos cree los objetos.
		//El patron factoría es un patron de diseno creacional, en la cual
		//su funcion es evitar el acoplamiento de clases, y de esta manera,
		//centralizar la creacion de los objetos en una unica clase
		
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();

		//Sigue el patron de diseno builder y cuya funcion es crear objetos
		//complejos de manera simple
		DocumentBuilder analizador;
		//el nodo documento
		Document dom;
		//Este nodo representara el nodo raiz en este ejemplo
		Node document;
		
		try {
			analizador = fabrica.newDocumentBuilder();
			dom = analizador.parse("concierto.xml");
			document = dom.getDocumentElement();
			recorrerNodos(document);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void recorrerNodos(Node raiz) {
		// Podemos saber que los hijos de nuestra raiz de esta forma
		NodeList nodos = raiz.getChildNodes();
		// Sabemos que la fecha es el 0, la hora es el 1 y los participantes el 2.
		Node fecha = nodos.item(0);
		Node hora = nodos.item(1);
		Node participantes = nodos.item(2);
		System.out.println("Fecha y hora del concierto: " + fecha.getTextContent() + " " + hora.getTextContent());
		System.out.println("Participan los siguientes grupos:");
		nodos = participantes.getChildNodes();
		for(int i=0; i<nodos.getLength(); i++) {
			Node participante = nodos.item(i);
			System.out.println(" " + participante.getChildNodes().item(0).getTextContent() + 
							   " " + participante.getChildNodes().item(1).getTextContent());		
		}
	}

}
