package es.urjc.etsii.dad.ContactoCero;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ejercicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String musculo;
	
	@JsonIgnore
	@OneToMany(mappedBy="ejercicio")
	private List<Rutina> rutina;
	
	

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

	public List<Rutina> getRutina() {
		return rutina;
	}

	public void setRutina(List<Rutina> rutina) {
		this.rutina = rutina;
	}
	
	@Override
	public String toString() {
		return "Ejercicio [nombre=" + nombre + ", musculo=" + musculo + "]";
	}
}
	
