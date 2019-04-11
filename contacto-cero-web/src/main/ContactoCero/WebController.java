package es.urjc.etsii.dad.ContactoCero;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class WebController implements CommandLineRunner {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	@Autowired
	private RutinaRepositorio repositorioRutina;
	@Autowired
	private EjercicioRepositorio repositorioEjercicio;
	@Autowired
	private DietasRepositorio repositorioDieta;

	
	@RequestMapping("/registro")
	public String registro(ModelMap model, @RequestParam String name, @RequestParam String pass,
			@RequestParam String correo, HttpServletRequest request) {
		model.put("name", name);
		model.put("pass", pass);
		if (name != null || pass != null) {
			Usuario u = new Usuario(name, pass, correo, "USER");
			usuarioRepositorio.save(u);
			RestTemplate rt = new RestTemplate();
			String url = "http://localhost:8080/envioCorreo?correo=" + correo + "&nombre=" + name;
			Boolean b = rt.getForObject(url, Boolean.class);
			return "mainPage";
		}
		return "login";
	}

	@GetMapping("/")
	public String cerrarSesion() {
		return "cerrarSesion";
	}

	@GetMapping("/login")
	public String login(HttpServletRequest request) {

		return "login";
	}

	@GetMapping("/redirregistro")
	public String redirregistro(HttpServletRequest request) {

		return "Registro_template";
	}

	@GetMapping("/errorLogin")
	public String errorLoging() {
		return "errorLogin";
	}

	@RequestMapping("/cogerRutina")
	public String cogerRutina(Model model, @RequestParam String nombreRutina, @RequestParam String nombreUser,
			HttpServletRequest request) {
		model.addAttribute("usuario", usuarioRepositorio.findAll());
		model.addAttribute("rutinas", repositorioRutina.findAll());
		Usuario u = usuarioRepositorio.findByNick(nombreUser);
		Rutina r = repositorioRutina.findByRutina(nombreRutina);
		try {
			u.setRutina(r);
			usuarioRepositorio.save(u);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "rutinas";

	}

	@RequestMapping("/asignarEjeraRut")
	public String asignarEjer(Model model, @RequestParam String nombreRutina, @RequestParam String nombreEjer) {
		model.addAttribute("ejercicios", repositorioEjercicio.findAll());
		model.addAttribute("rutinas", repositorioRutina.findAll());

		Ejercicio e = repositorioEjercicio.findByNombre(nombreEjer);
		Rutina r = repositorioRutina.findByRutina(nombreRutina);
		try {
			r.setEjercicio(e);
			repositorioRutina.save(r);

		} catch (Exception er) {
			er.printStackTrace();
		}

		return "ejercicios";

	}

	@GetMapping("/mainPage")
	public String perfil(ModelMap model, HttpServletRequest request) {		
		model.addAttribute("admin", request.isUserInRole("ADMIN"));

		return "mainPage";
	}

	@RequestMapping("/crearRutina")
	public String RutinaNueva(ModelMap model, @RequestParam String nombre, @RequestParam String descripcion) {

		Rutina rutina = new Rutina(nombre, descripcion);
		repositorioRutina.save(rutina);
		model.addAttribute("rutinas", repositorioRutina.findAll());

		return "rutinas";
	}

	@RequestMapping("/crearEjercicio")
	public String EjercicioNuevo(ModelMap model, @RequestParam String nombre, @RequestParam String descripcion) {

		Ejercicio ejercicio = new Ejercicio(nombre, descripcion);
		repositorioEjercicio.save(ejercicio);
		model.addAttribute("ejercicios", repositorioEjercicio.findAll());
		return "ejercicios";
	}

	@RequestMapping("/crearDieta")
	public String DietaNueva(ModelMap model, @RequestParam String nombre, @RequestParam String descripcion,
			@RequestParam String peso) {

		Dietas dieta = new Dietas(nombre, descripcion, peso);
		repositorioDieta.save(dieta);

		model.addAttribute("dietas", repositorioDieta.findAll());
		return "dietas";
	}

	@GetMapping("/ejercicios")
	public String ejercicios(ModelMap model, HttpServletRequest request) {
		model.addAttribute("ejercicios", repositorioEjercicio.findAll());
		return "ejercicios";
	}

	@GetMapping("/rutinas")
	public String rutinas(ModelMap model, HttpServletRequest request) {
		model.addAttribute("rutinas", repositorioRutina.findAll());
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

	@GetMapping("/adminPage")
	public String admin(ModelMap model) {
		model.addAttribute("usuarios", usuarioRepositorio.findAll()); //no borrar
		return "adminPage";
	}

	@Override
	public void run(String... args) throws Exception {

		Rutina definicion = new Rutina("Rutina definicion",
				"Esta rutina se basa en la realización de muchas repeticiones por serie con poco peso");
		Rutina volumen = new Rutina("Rutina volumen",
				"Esta rutina se basa en la realización de pocas repeticiones por serie con mucho peso");
		Rutina perdida = new Rutina("Rutina perdida de peso",
				"Esta rutina se basa en la realización de cardio y ejercicios aerobicos");

		Ejercicio remo = new Ejercicio("Remo", "Espalda");
		Ejercicio pressBanca = new Ejercicio("Press", "Pecho");
		Ejercicio sentadillas = new Ejercicio("Sentadillas", "Pierna");
		Ejercicio frances = new Ejercicio("Frances", "Brazo");

		Dietas hypercalorica = new Dietas("hypercalorica", "potenciar", "ganar");
		Dietas hipocalorica = new Dietas("hipocalorica", "reducir", "perder");
		Dietas mantenimiento = new Dietas("mantenimiento", "mantener", "perder o ganar");

		repositorioDieta.save(hypercalorica);
		repositorioDieta.save(hipocalorica);
		repositorioDieta.save(mantenimiento);

		repositorioEjercicio.save(remo);
		repositorioEjercicio.save(pressBanca);
		repositorioEjercicio.save(sentadillas);
		repositorioEjercicio.save(frances);

		// volumen.setEjercicio(remo);

		repositorioRutina.save(volumen);
		repositorioRutina.save(definicion);
		repositorioRutina.save(perdida);

		// user1.setRutina(definicion);
		// user2.setRutina(perdida);

	}
}