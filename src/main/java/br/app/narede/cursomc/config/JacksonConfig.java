package br.app.narede.cursomc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.app.narede.cursomc.domain.PagamentoComBoleto;
import br.app.narede.cursomc.domain.PagamentoComCartao;

@Configuration
public class JacksonConfig {

	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() 
	{
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() 
		{
			public void configure(ObjectMapper objectMapper) 
			{
				objectMapper.registerSubtypes(PagamentoComCartao.class);
				objectMapper.registerSubtypes(PagamentoComBoleto.class);
			}
		};

		return builder;
	}
}
