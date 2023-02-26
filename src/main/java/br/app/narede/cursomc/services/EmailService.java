package br.app.narede.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import br.app.narede.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido pedido);

	void sendOrderConfirmationHtmlEmail(Pedido pedido);
	
	void sendEmail(SimpleMailMessage  msg);
	void sendHtmlEmail(MimeMessage  msg);
}
