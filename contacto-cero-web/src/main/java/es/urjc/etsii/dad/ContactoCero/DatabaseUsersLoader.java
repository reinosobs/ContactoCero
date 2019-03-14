package es.urjc.etsii.dad.ContactoCero;

import javax.annotation.PostConstruct;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUsersLoader {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @PostConstruct
    private void initDatabase() {
    	
    	usuarioRepositorio.save(new Usuario("user", "pass", "ROLE_USER"));
    	usuarioRepositorio.save(new Usuario("Luis", "hola", "ROLE_USER"));
    	usuarioRepositorio.save(new Usuario("admin", "adminpass", "ROLE_USER", "ROLE_ADMIN"));
    }

}