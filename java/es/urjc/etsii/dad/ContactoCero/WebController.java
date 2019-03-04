package es.urjc.etsii.dad.ContactoCero;

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
	private UsuarioRepositorio repositorioUsuario;
	@Autowired
	private RutinaRepositorio repositorioRutina;
	@Autowired
	private EjercicioRepositorio repositorioEjercicio;
	@Autowired
	private DietasRepositorio repositorioDieta;
	
	@RequestMapping("/login2")
	public String login(ModelMap model, @RequestParam String name, @RequestParam String pass) {
	 
	model.put("name", name);
	model.put("pass", pass);
	 Usuario u= new Usuario(name, pass);
	 if(u.equals(repositorioUsuario.findByNickAndClave(name, pass))) {
	 	return "mainPage";
	 }
	 else {
	 	return "errorLoging";
	 }
	}

	@RequestMapping("/cogerRutina")
	public String cogerRutina(Model model, @RequestParam String nombreRutina, @RequestParam String nombreUser){
		model.addAttribute("usuario", repositorioUsuario.findAll());
		model.addAttribute("rutinas", repositorioRutina.findAll());
		
		Usuario u = repositorioUsuario.findByNick(nombreUser);
		Rutina r= repositorioRutina.findByRutina(nombreRutina);
		try {
			u.setRutina(r);
			repositorioUsuario.save(u);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "rutinas";
		
		
		
	}
	@RequestMapping("/asignarEjeraRut")
	public String asignarEjer(Model model, @RequestParam String nombreRutina, @RequestParam String nombreEjer){
		model.addAttribute("ejercicios", repositorioEjercicio.findAll());
		model.addAttribute("rutinas", repositorioRutina.findAll());
		
		Ejercicio e = repositorioEjercicio.findByNombre(nombreEjer);
		Rutina r= repositorioRutina.findByRutina(nombreRutina);
		try {
			r.setEjercicio(e);
			repositorioRutina.save(r);
			
		}catch(Exception er) {
			er.printStackTrace();
		}
		
		return "ejercicios";
		
		
		
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
			repositorioUsuario.save(u);
			 return "mainPage";
		}
		return "login2";
		 
		 
	}
	
	@RequestMapping("/crearRutina")
	public String RutinaNueva(ModelMap model, @RequestParam String nombre, @RequestParam String descripcion) {

		
		Rutina rutina= new Rutina (nombre, descripcion);
		repositorioRutina.save(rutina);	
		model.addAttribute("rutinas",repositorioRutina.findAll());
		
		return "rutinas";
		
	}
	
	@RequestMapping("/crearEjercicio")
	public String EjercicioNuevo(ModelMap model, @RequestParam String nombre, @RequestParam String descripcion) {

	
		Ejercicio ejercicio= new Ejercicio (nombre, descripcion);
		repositorioEjercicio.save(ejercicio);
		model.addAttribute("ejercicios",repositorioEjercicio.findAll());
		return "ejercicios";
	}
	
	@RequestMapping("/crearDieta")
	public String DietaNueva(ModelMap model, @RequestParam String nombre, @RequestParam String descripcion, @RequestParam String peso) {
		
		Dietas dieta= new Dietas (nombre, descripcion, peso );
		repositorioDieta.save(dieta);

		model.addAttribute("dietas",repositorioDieta.findAll());
		return "dietas";
	}
	
	
	
	@GetMapping("/redirregistro")
		public String redirregistro(ModelMap model){
		return "Registro_template";
	}
	
	
	
	@GetMapping("/ejercicios")
	public String ejercicios(ModelMap model) {
		model.addAttribute("ejercicios", repositorioEjercicio.findAll());
		return "ejercicios";
	}
	
	@GetMapping("/rutinas")
	public String rutinas(ModelMap model) {
		model.addAttribute("rutinas",repositorioRutina.findAll());
		
		
		return "rutinas";
	}
	
	@GetMapping("/dietas")
	public String dietas(ModelMap model) {
		model.addAttribute("dietas", repositorioDieta.findAll());
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
		Ejercicio pressBanca= new Ejercicio("Press","Pecho");
		Ejercicio sentadillas= new Ejercicio("Sentadillas","Pierna");
		Ejercicio frances= new Ejercicio("Frances","Brazo");
		
		Usuario user1= new Usuario("Sergio","1234");
		Usuario user2= new Usuario("Luis","hola");
		
		Dietas hypercalorica= new Dietas("hypercalorica","potenciar","ganar");
		Dietas hipocalorica= new Dietas("hipocalorica","reducir","perder");
		Dietas mantenimiento= new Dietas("mantenimiento","mantener","perder o ganar");
		
		
		
		repositorioDieta.save(hypercalorica);
		repositorioDieta.save(hipocalorica);
		repositorioDieta.save(mantenimiento);
		
		
		repositorioEjercicio.save(remo);
		repositorioEjercicio.save(pressBanca);
		repositorioEjercicio.save(sentadillas);
		repositorioEjercicio.save(frances);
		
		//volumen.setEjercicio(remo);
		
		repositorioRutina.save(volumen);
		repositorioRutina.save(definicion);
		repositorioRutina.save(perdida);
		
		//user1.setRutina(definicion);
		//user2.setRutina(perdida);
		
		repositorioUsuario.save(user1);
		repositorioUsuario.save(user2);
		
		
		Usuario admin= new Usuario("admin", "admin");
		repositorioUsuario.save(admin);
		
	}
}