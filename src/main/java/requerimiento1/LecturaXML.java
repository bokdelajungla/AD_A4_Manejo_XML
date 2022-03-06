package requerimiento1;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LecturaXML {

	public static void main(String[] args) {
		//Lo primero necesitamos una factoria que nos cree los objetos.
		//El patron factoría es un patron de diseño creacional, en la cual
		//su funcion es evitar el acoplamiento de clases, y de esta manera,
		//centralizar la creacion de los objetos en una unica clase
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();

		//Sigue el patron de diseño builder y cuya funcion es crear objetos
		//complejos de manera simple
		DocumentBuilder analizador;
		//el nodo documento
		Document dom;
		//Este nodo representara el nodo raiz en este ejemplo
		Node raiz;
		
		try {
			analizador = fabrica.newDocumentBuilder();
			//Lo primero es deserializar el fichero concierto.xml para
			//convertilo en un arbol DOM, basicamente lo que hacen los navegadores
			//El arbol DOM seran objetos con una jerarquia en forma de arbol
			dom = analizador.parse("concierto.xml");
			//Ponemos la referencia raiz en el objeto Document
			raiz = dom.getDocumentElement();
			recorrerNodos(raiz);
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	private static void recorrerNodos(Node raiz) {
		//este metodo nos devuelve todos los nodos hijos Directos del elemento raiz "concierto"
		NodeList nodos = raiz.getChildNodes();
		//Hay que tener cuidado con este método porque porque los saltos de linea 
		//que hay entre las etiquetas se cuentan como nodos texto
		//En nuestro caso no hay saltos de línea, porque hemos creado el fichero de esa forma
		System.out.println("Elementos en el nodo raíz: " + nodos.getLength()); //3
		//Presentamos la información de los dos primeros nodos de forma sencilla ya que sólo tienen un elemento
		Node fecha = nodos.item(0);
		Node hora = nodos.item(1);
		System.out.println("Fecha y hora del concierto: " + fecha.getTextContent() + " " + hora.getTextContent());
		//Para los participantes recorremos el nodo para presentar toda la info
		Node participantes = nodos.item(2);
		System.out.println("Elementos en el nodo participantes: " + nodos.getLength()); //3
		System.out.println("Participan los siguientes grupos:");
		nodos = participantes.getChildNodes();
		for(int i=0; i<nodos.getLength(); i++) {
			Node participante = nodos.item(i);
			System.out.println(" " + participante.getChildNodes().item(0).getTextContent() + 
							   " " + participante.getChildNodes().item(1).getTextContent());		
		}
	}
}
