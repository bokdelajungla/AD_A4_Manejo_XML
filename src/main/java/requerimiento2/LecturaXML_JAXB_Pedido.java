package requerimiento2;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import modelo.entidad.concierto.Participante;
import modelo.entidad.pedido.Articulo;
import modelo.entidad.pedido.Pedido;

public class LecturaXML_JAXB_Pedido {

	public static void main(String[] args) {
		try {
			JAXBContext contexto = JAXBContext.newInstance(Pedido.class);
			//Esta vez creamos un objeto que nos permite pasar
			//de XML a Object, es decir deserializar
			Unmarshaller u = contexto.createUnmarshaller();
			File fichero = new File("pedido_jaxb.xml");
			if (fichero.exists()) {
				Pedido pedido = (Pedido) u.unmarshal(fichero); //Hacemos un cast a Concierto
				System.out.println("ID del pedido: " + pedido.getIdPedido());
				System.out.println("Cliente: " + pedido.getCliente().getNombre() + " - " +  pedido.getCliente().getDNI());
				for(Articulo a: pedido.getListaArticulos()) {
					System.out.println(" " + a.getNombre() + " x " + a.getUnidades() + " = " +
										a.getPrecio()*a.getUnidades());
				}
			} else {
				System.out.println("Fichero XML pedido_jaxb.xml no encontrado");
				System.out.println("Ejecute primero \"Principal_JAXB_Pedido\"");
			}

		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}
	}

}
