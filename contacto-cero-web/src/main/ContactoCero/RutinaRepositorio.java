package es.urjc.etsii.dad.ContactoCero;

import org.springframework.data.repository.CrudRepository;

public interface RutinaRepositorio  extends CrudRepository<Rutina, Integer>{
	Rutina findByRutina (String rutina);
}

