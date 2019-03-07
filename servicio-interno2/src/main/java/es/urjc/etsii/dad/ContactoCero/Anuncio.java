package es.urjc.etsii.dad.ContactoCero;

public class Anuncio {
	String nombre;
	String anuncio;
	String descripcion;
	
	public Anuncio(String string, String string2, String string3) {
		this.nombre= string;
		this.anuncio= string2;
		this.descripcion= string3;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(String anuncio) {
		this.anuncio = anuncio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
