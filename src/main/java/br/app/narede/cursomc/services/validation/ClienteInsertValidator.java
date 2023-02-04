package br.app.narede.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.app.narede.cursomc.domain.Cliente;
import br.app.narede.cursomc.domain.enums.TipoCliente;
import br.app.narede.cursomc.dto.ClienteNewDTO;
import br.app.narede.cursomc.repositories.ClienteRepository;
import br.app.narede.cursomc.resources.exceptions.FieldMessage;
import br.app.narede.cursomc.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public  void initialize(ClienteInsert ann) {
		
	};
	
	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
			
		// tests
		if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod())) {
			if (!BR.isValidCPF(objDto.getCpfOuCnpj())) {
				list.add(new FieldMessage("CpfOuCnpj", "CPF Inválido"));
			}
		}
			
		if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod())) {
			if (!BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
				list.add(new FieldMessage("CpfOuCnpj", "CNPJ Inválido"));
			}
		}
			
		Cliente aux = repo.findByEmail(objDto.getEmail());
		
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		
		for (FieldMessage e: list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage())
			.addPropertyNode(e.getFieldName())
			.addConstraintViolation();
		}
		
		return list.isEmpty();
	}
	

}

