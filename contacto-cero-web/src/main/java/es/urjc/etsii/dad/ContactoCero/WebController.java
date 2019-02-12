package es.urjc.etsii.dad.ContactoCero;

//import java.awt.List;
import java.util.List;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class WebController {
	Usuario u= new Usuario("Luis", "1234");
	@RequestMapping("/login2")
	public String login(ModelMap model, @RequestParam String name, @RequestParam String pass) {
	 model.put("name", name);
	 model.put("pass", pass);
	 	/*if(name.equals(u.getNick())&& (pass.equals(u.getClave()))){
		 	return "mainPage";
	 	}else {		 
		 	return "errorLogin";
		}*/
	 	if(name!=null) {
	 		return "mainPage";
	 	}
	 	else {
	 		return "errorLoging";
	 	}
		}
	
	
	
	@GetMapping("/mainPage")
	public String perfil(ModelMap model) {//, @RequestParam String name) {
		//model.addAttribute(name);
		return "mainPage";
	}
	
	@GetMapping("/ejercicios")
	public String ejercicios(ModelMap model) {
		return "ejercicios";
	}
	
	@GetMapping("/rutinas")
	public String rutinas(ModelMap model) {
		return "rutinas";
	}
	
	@GetMapping("/contacto")
	public String contacto(ModelMap model) {
		return "contacto";
	}
}

