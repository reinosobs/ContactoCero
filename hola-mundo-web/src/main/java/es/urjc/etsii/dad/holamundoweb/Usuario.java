package es.urjc.etsii.dad.holamundoweb;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	String nick= "";
	String clave= "";
	private static ArrayList<Usuario> lista_usuarios; 
	
	public Usuario (String nick, String clave) {
		this.nick = nick;
		this.clave = clave;
		lista_usuarios = new ArrayList<Usuario>(); 
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
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public boolean equals (Usuario u){
        return this.nick.equals(u.nick);
    }
    
    public ArrayList<Usuario> getUsuarios(){
        return lista_usuarios;
    }
    
    public void setUsuarios(ArrayList<Usuario> usuarios){
        Usuario.lista_usuarios=usuarios;
    }
    
    public Usuario autenticar() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Usuario: ");
        String login = entrada.nextLine();
        System.out.print("Password: ");
        String pass = entrada.nextLine();
        for (Usuario u : lista_usuarios) {
            if (u.getNick().equals(login) && u.getClave().equals(pass)) {
                return u;
            }
        }
        return null;
    }
    
public boolean registrar(Usuario nuevo) {
        
        boolean sePuede=true;
        for(Usuario u: lista_usuarios){
            if(u.getNick().contains(nuevo.getNick())){
                sePuede=false;
            }
        }
        if(sePuede==true){
            this.lista_usuarios.add(nuevo);
        }
        return sePuede;
    }
}
