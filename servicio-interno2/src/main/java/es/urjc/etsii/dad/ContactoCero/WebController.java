package es.urjc.etsii.dad.ContactoCero;

//import java.awt.List;
import java.util.List;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class WebController{	
	 @GetMapping("/anuncio")
	 public Anuncio anuncios() {
	 return new Anuncio("Pepe","Vendo moto", "...");
	 }
	
	@PostMapping(value = "/anuncios")
	//@ResponseStatus(HttpStatus.CREATED)
	 public Anuncio nuevoAnuncio(@RequestBody Anuncio anuncio) {
	 //Se guarda el nuevo anuncio en memoria o BBDD.
	 //Se guarda en el anuncio un id único y se devuelve
	 return anuncio;
	 }

}

