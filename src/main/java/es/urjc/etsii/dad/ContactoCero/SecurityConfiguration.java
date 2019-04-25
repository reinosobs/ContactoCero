package es.urjc.etsii.dad.ContactoCero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    public UserRepositoryAuthenticationProvider authenticationProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Public pages
		http.authorizeRequests().antMatchers("/imagenes/*").permitAll();
		http.authorizeRequests().antMatchers("/estilos/*").permitAll();
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/redirregistro").permitAll();
		http.authorizeRequests().antMatchers("/registro").permitAll();
		http.authorizeRequests().antMatchers("/errorLogin").permitAll();
		http.authorizeRequests().antMatchers("/logout").permitAll();
		
		// Private pages (all other pages)
		//http.authorizeRequests().anyRequest().authenticated();
		http.authorizeRequests().antMatchers("/mainPage").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/adminPage").hasAnyRole("ADMIN");
		
		
		// Login form
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("name");
		http.formLogin().passwordParameter("pass");
		http.formLogin().defaultSuccessUrl("/mainPage");
		http.formLogin().failureUrl("/errorLogin");
		// Logout
		http.logout().logoutUrl("/logout");
		http.logout().logoutSuccessUrl("/");
		
		http.csrf().disable();

	}

	@Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
    	
        // Users
    	auth.authenticationProvider(authenticationProvider);
    }

}
