package es.urjc.etsii.dad.ContactoCero;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ejercicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String musculo;
	
	@OneToMany(mappedBy="ejercicio")
	private List<Rutina> rutinas;
	
	protected Ejercicio() {}
	
	public Ejercicio(String nombre, String musculo) {
		this.nombre=nombre;
		this.musculo=musculo;
	}

	public String getNombre() {
		return nombre;
	}


	public String getMusculo() {
		return musculo;
	}


	@Override
	public String toString() {
		return "Ejercicio [nombre=" + nombre + ", musculo=" + musculo + "]";
	}
}
	
