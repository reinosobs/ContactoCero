package es.urjc.etsii.dad.ContactoCero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
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
		if (name!=null && pass!=null) {
			Usuario u= new Usuario(name, pass);
			repositorio.save(u);
			 return "mainPage";
		}
		return "login2";
		 
		 
	}
	
	@RequestMapping("/crearRutina")
	public String RutinaNueva(ModelMap model, @RequestParam String nombre, @RequestParam String descripcion) {
		model.put("nombre", nombre);
		model.put("descripcion", descripcion);
		
		Rutina rutina= new Rutina (nombre, descripcion);
		repositorio1.save(rutina);		
		return "rutinas";
	}
	
	@RequestMapping("/crearEjercicio")
	public String EjercicioNuevo(ModelMap model, @RequestParam String nombre, @RequestParam String descripcion) {
		model.put("nombre", nombre);
		model.put("descripcion", descripcion);
		
		Ejercicio ejercicio= new Ejercicio (nombre, descripcion);
		repositorio2.save(ejercicio);		
		return "ejercicios";
	}
	
	@RequestMapping("/crearDieta")
	public String DietaNueva(ModelMap model, @RequestParam String nombre, @RequestParam String descripcion, @RequestParam String peso) {
		model.put("nombre", nombre);
		model.put("descripcion", descripcion);
		model.put("peso", peso);
		
		Dietas dieta= new Dietas (nombre, descripcion, peso );
		repositorio3.save(dieta);		
		return "dietas";
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
		
		Rutina definicion= new Rutina("Rutina definicion","Esta rutina se basa en la realización de muchas repeticiones por serie con poco peso");
		Rutina volumen= new Rutina("Rutina volumen","Esta rutina se basa en la realización de pocas repeticiones por serie con mucho peso");
		Rutina perdida= new Rutina("Rutina perdida de peso","Esta rutina se basa en la realización de cardio y ejercicios aerobicos");
		
		Ejercicio remo= new Ejercicio("Remo","Espalda");
		
		Usuario user1= new Usuario("Sergio","1234");
		Usuario user2= new Usuario("Luis","hola");
		
		Dietas hypercalorica= new Dietas("hypercalorica","potenciar","ganar");
		Dietas hipocalorica= new Dietas("hipocalorica","reducir","perder");
		Dietas mantenimiento= new Dietas("mantenimiento","mantener","perder o ganar");
		
		
		
		repositorio3.save(hypercalorica);
		repositorio3.save(hipocalorica);
		repositorio3.save(mantenimiento);
		
		
		repositorio2.save(remo);
		
		volumen.setEjercicio(remo);
		
		repositorio1.save(volumen);
		repositorio1.save(definicion);
		repositorio1.save(perdida);
		
		//user1.setRutina(definicion);
		//user2.setRutina(perdida);
		
		repositorio.save(user1);
		repositorio.save(user2);
		
		
		Usuario admin= new Usuario("admin", "admin");
		repositorio.save(admin);
		
	}
}