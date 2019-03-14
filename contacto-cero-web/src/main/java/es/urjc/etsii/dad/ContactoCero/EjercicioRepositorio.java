package es.urjc.etsii.dad.ContactoCero;

import org.springframework.data.repository.CrudRepository;

public interface EjercicioRepositorio extends CrudRepository<Ejercicio, Integer>{
	Ejercicio findByNombre (String ejer);
}
