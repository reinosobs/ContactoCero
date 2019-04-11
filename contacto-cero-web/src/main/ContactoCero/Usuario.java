package es.urjc.etsii.dad.ContactoCero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.annotation.SessionScope;

@Entity
@SessionScope
public class Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nick;
	private String passwordHash;
	private String correo;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	private static ArrayList<Usuario> lista_usuarios; 
	
	protected Usuario() {}
	
	public Usuario (String nick, String password, String correo, String... roles) {
		this.nick = nick;
		this.passwordHash = new BCryptPasswordEncoder().encode(password);
		this.correo=correo;
		this.roles = new ArrayList<>(Arrays.asList(roles));
	}
	
	public String getNick() {
        return nick;
    }
    
    public void setNick(String nick) {
        this.nick = nick;
    }
    public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
}
    
	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	} 
	
	public String getPasswordHash() {
        return passwordHash;
    }
      
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    
	@ManyToOne
	private Rutina rutina; 
   
    public void setRutina(Rutina rut) {
    	this.rutina=rut;
    }
    public boolean equals (Usuario u){
        return this.nick.equals(u.getNick())&& this.passwordHash.equals(u.getPasswordHash());
    }
    
    public ArrayList<Usuario> getUsuarios(){
        return lista_usuarios;
    }
    
}
