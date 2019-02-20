package es.urjc.etsii.dad.ContactoCero;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Rutina rutinas; 
	
	String nick;
	String clave;
	private static ArrayList<Usuario> lista_usuarios; 
	
	protected Usuario() {}
	
	public Usuario (String nick, String clave) {
		this.nick = nick;
		this.clave = clave;
	}
	
	public String getNick() {
        return nick;
    }
    
    public void setNick(String nick) {
        this.nick = nick;
    }
    
    public String getClave() {
        return clave;
    }
    public void setRutina(Rutina rut) {
    	this.rutinas=rut;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public boolean equals (Usuario u){
        return this.nick.equals(u.getNick())&& this.clave.equals(u.getClave());
    }
    
    public ArrayList<Usuario> getUsuarios(){
        return lista_usuarios;
    }
    
}
