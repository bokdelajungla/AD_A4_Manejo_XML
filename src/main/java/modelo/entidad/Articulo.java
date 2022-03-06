package modelo.entidad;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="articulo")
@XmlType(propOrder = {
		"idArticulo",
	    "nombre",
	    "precio",
	    "unidades"
	})
public class Articulo {
	
	private int idArticulo;
	private String nombre;
	private double precio;
	private int unidades;
	
	public Articulo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Articulo(int idArticulo, String nombre, double precio, int unidades) {
		super();
		this.idArticulo = idArticulo;
		this.nombre = nombre;
		this.precio = precio;
		this.unidades = unidades;
	}
	
	//toString()
	@Override
	public String toString() {
		return "Articulo [idArticulo=" + idArticulo + ", nombre=" + nombre + ", precio=" + precio + ", unidades="
				+ unidades + "]";
	}
	
	//GETTERS & SETTERS
	@XmlAttribute(name = "id")
	public int getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
}
