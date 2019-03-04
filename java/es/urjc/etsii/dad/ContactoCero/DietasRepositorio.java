package es.urjc.etsii.dad.ContactoCero;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DietasRepositorio extends CrudRepository<Dietas, Integer>{
	
	List<Dietas> findAll();
}
