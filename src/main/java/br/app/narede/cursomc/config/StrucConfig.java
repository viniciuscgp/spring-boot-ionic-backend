package br.app.narede.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.app.narede.cursomc.services.DBService;

@Configuration
@Profile("struc")
public class StrucConfig {
	@Autowired
	private DBService dbservice;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		if (!strategy.contains("create")) {
			return false;
		}

		dbservice.instantiateTestDatabase();
 		
		return true;
	}
}
