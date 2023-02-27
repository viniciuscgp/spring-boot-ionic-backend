package br.app.narede.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.app.narede.cursomc.services.DBService;
import br.app.narede.cursomc.services.EmailService;
import br.app.narede.cursomc.services.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {
	@Autowired
	private DBService dbservice;

	@Bean
	public boolean instantiateDatabase() throws ParseException {
	
		dbservice.instantiateTestDatabase();
 		
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
		
	
}
