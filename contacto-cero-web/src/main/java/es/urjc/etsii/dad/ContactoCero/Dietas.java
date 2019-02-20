package es.urjc.etsii.dad.ContactoCero;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dietas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String dieta;
	private String finalidad;
	private String peso;
	
	
	protected Dietas() {}
	
	public Dietas(String dieta, String finalidad, String peso) {
		this.dieta=dieta;
		this.finalidad=finalidad;
		this.peso=peso;
	}

	public String getDieta() {
		return dieta;
	}


	public String getFinalidad() {
		return finalidad;
	}

	public String getPeso() {
		return peso;
	}

	@Override
	public String toString() {
		return "Dietas [id=" + id + ", dieta=" + dieta + ", finalidad=" + finalidad + ", peso=" + peso +"]";
	}


}