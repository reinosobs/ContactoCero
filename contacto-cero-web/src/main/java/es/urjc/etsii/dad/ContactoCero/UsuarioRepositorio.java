package es.urjc.etsii.dad.ContactoCero;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer>{
	Usuario findByNick (String nick);

}
