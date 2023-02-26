package br.app.narede.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import br.app.narede.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido pedido);
	
	void sendEmail(SimpleMailMessage  msg);
}
