package es.urjc.etsii.dad.ContactoCero;

//import java.awt.List;
import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepositorio repositorio;
	@Autowired
	private RutinaRepositorio repositorio1;
	@Autowired
	private EjercicioRepositorio repositorio2;
	@Autowired
	private DietasRepositorio repositorio3;
	
	@RequestMapping("/login2")
	public String login(ModelMap model, @RequestParam String name, @RequestParam String pass) {
	 
	model.put("name", name);
	model.put("pass", pass);
	 Usuario u= new Usuario(name, pass);
	 if(u.equals(repositorio.findByNickAndClave(name, pass))) {
	 	return "mainPage";
	 }
	 else {
	 	return "errorLoging";
	 }
	}

	
	@GetMapping("/redirlogin")
	public String redirlogin(ModelMap model){
		return "login2";
	}
	@GetMapping("/mainPage")
	public String perfil(ModelMap model) {//, @RequestParam String name) {
		//model.addAttribute(name);
		return "mainPage";
	}
	
	@RequestMapping("/registro")
	public String registro(ModelMap model, @RequestParam String name, @RequestParam String pass) {
		model.put("name", name);
		model.put("pass", pass);
		 Usuario u= new Usuario(name, pass);
		 repositorio.save(u);
		 return "mainPage";
	}
	
	@GetMapping("/redirregistro")
		public String redirregistro(ModelMap model){
		return "Registro_template";
	}
	
	@GetMapping("/ejercicios")
	public String ejercicios(ModelMap model) {
		return "ejercicios";
	}
	
	@GetMapping("/rutinas")
	public String rutinas(ModelMap model) {
		return "rutinas";
	}
	
	@GetMapping("/dietas")
	public String dietas(ModelMap model) {
		return "dietas";
	}
	
	@GetMapping("/contacto")
	public String contacto(ModelMap model) {
		return "contacto";
	}



	@Override
public void run(String... args) throws Exception {
		
		Rutina espalda= new Rutina("espalda",'F');
		
		Ejercicio remo= new Ejercicio("Remo","Espalda");
		
		Usuario user1= new Usuario("Sergio","1234");
		Usuario user2= new Usuario("Luis","hola");
		
		Dietas hypercalorica= new Dietas("hypercalorica","potenciar","ganar");
		Dietas hipocalorica= new Dietas("hipocalorica","reducir","perder");
		Dietas mantenimiento= new Dietas("mantenimiento","mantener","perder o ganar");
		
		repositorio1.save(espalda);
		
		repositorio3.save(hypercalorica);
		repositorio3.save(hipocalorica);
		repositorio3.save(mantenimiento);
		
		//remo.getRutinas().add(espalda);
		//repositorio2.save(remo);
		
		user1.setRutina(espalda);
		user2.setRutina(espalda);
		
		repositorio.save(user1);
		repositorio.save(user2);
		
		
		Usuario admin= new Usuario("admin", "admin");
		repositorio.save(admin);
		
	}
}