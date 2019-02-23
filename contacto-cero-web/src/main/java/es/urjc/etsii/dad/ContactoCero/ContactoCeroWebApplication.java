package es.urjc.etsii.dad.ContactoCero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactoCeroWebApplication {
	
	
	private static Usuario admin = new Usuario("Luis", "1234");
    private static Usuario admin2 = new Usuario("Dani", "1234");
    
	public static void main(String[] args) {
		SpringApplication.run(ContactoCeroWebApplication.class, args);
	}

}

