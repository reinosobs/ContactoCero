package es.urjc.etsii.dad.ContactoCero;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Rutina {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String rutina;
	private char dificultad;
	
	@OneToMany(mappedBy= "rutinas")
	private List<Ejercicio> usuarios;
	
	
	public long getId() {
		return id;
	}


	@ManyToOne
	private Ejercicio ejercicio;
	
	protected Rutina() {}
	
	public Rutina(String rutina, char dificultad) {
		this.rutina=rutina;
		this.dificultad=dificultad;
	}

	public String getRutina() {
		return rutina;
	}

	public char getDificultad() {
		return dificultad;
	}


	@Override
	public String toString() {
		return "Rutina [rutina=" + rutina + ", dificultad=" + dificultad + "]";
	}
	
	

}
