package beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="participante")
public class Participante {
	private String entrada;
	private String grupo;
	
	public Participante() {
		
	}

	public Participante(String entrada, String grupo) {
		this.entrada = entrada;
		this.grupo = grupo;
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	
	
	
	
	
}


