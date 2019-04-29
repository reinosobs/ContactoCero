package es.urjc.etsii.dad.ContactoCero;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Rutina {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String rutina;
	private String descripcion;
	
	@JsonIgnore
	@OneToMany(mappedBy= "rutina")
	private List<Usuario> usuarios;
	
	@JsonIgnore
	@ManyToOne
	private Ejercicio ejercicio;
	
	
	protected Rutina() {}
	
	public Rutina(String rutina, String descripcion) {
		this.rutina=rutina;
		this.descripcion=descripcion;
	}

	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Ejercicio getEjercicio() {
		return ejercicio;
	}

	public long getId() {
		return id;
	}

	public String getRutina() {
		return rutina;
	}

	public String getDescription() {
		return descripcion;
	}
	
	public void setEjercicio(Ejercicio e) {
		this.ejercicio=e;
	}


	@Override
	public String toString() {
		return "Rutina [rutina=" + rutina + ", dificultad=" + descripcion + "]";
	}
	
	

}
