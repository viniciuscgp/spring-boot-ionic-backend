package br.app.narede.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.app.narede.cursomc.domain.Cliente;

public class ClienteDTO  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min=5, max=120, message = "O tamanho deve ser entre 5 e 80 caracteres")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
    @Email(message = "Email inválido!")	
	private String email;
	
	
	public ClienteDTO() {}

	public ClienteDTO(Integer id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
	public ClienteDTO(Cliente obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
		
	
}
