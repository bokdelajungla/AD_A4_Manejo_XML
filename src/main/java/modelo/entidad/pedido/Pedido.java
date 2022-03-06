package modelo.entidad.pedido;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="pedido")
@XmlType(propOrder = {
		"idPedido",
	    "cliente",
	    "listaArticulos"
	})
public class Pedido {
	
	private int idPedido;
	private Cliente cliente;
	private List<Articulo> listaArticulos;	
	
	public Pedido() {
		super();
		this.listaArticulos = new ArrayList<Articulo>();
	}	
	
	@XmlElement(name = "articulo")
	@XmlElementWrapper(name = "articulos")
	public List<Articulo> getListaArticulos() {
		return listaArticulos;
	}
	public void setListaArticulos(List<Articulo> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}
	
	@XmlAttribute(name = "id")
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	

}
