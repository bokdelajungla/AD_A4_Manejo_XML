package requerimiento2;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import modelo.entidad.pedido.Articulo;
import modelo.entidad.pedido.Cliente;
import modelo.entidad.pedido.Pedido;

public class Principal_JAXB_Pedido {

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
			contexto = JAXBContext.newInstance(Pedido.class);//inyeccion de dependecia
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
			Pedido pedido = new Pedido();
			pedido.setIdPedido(12345);
			pedido.setCliente(new Cliente("Antonio Castro", "01234567X"));
			
			pedido.getListaArticulos().add(new Articulo(12, "Castañas Asadas", 2, 2));
			pedido.getListaArticulos().add(new Articulo(23, "Coca-Cola Zero", 2.1, 3));
			pedido.getListaArticulos().add(new Articulo(54, "Zumo de Piña", 2.67, 1));

			
			//Convertimos un objeto a xml y lo imprimimos por pantalla
			m.marshal(pedido, System.out);
			//tambien podemos crear un fichero
			m.marshal(pedido, new File("pedido_jaxb.xml"));
		} catch (JAXBException e) {
			System.out.println("Error convirtiendo el objeto a formato XML");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
}

