package es.urjc.etsii.dad.ContactoCero;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;


@CacheConfig(cacheNames="ejercicios")
public interface EjercicioRepositorio extends CrudRepository<Ejercicio, Integer>{
	
	@CacheEvict(allEntries=true)
	Ejercicio save (Ejercicio ejercicio);
	
	@Cacheable
	Ejercicio findByNombre (String ejer);
	
	@Cacheable
	List<Ejercicio> findAll();
}
