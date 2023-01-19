package br.app.narede.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.narede.cursomc.domain.Cliente;
import br.app.narede.cursomc.repositories.ClienteRepository;
import br.app.narede.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(()->{
			 return new ObjectNotFoundException("Objeto não encontrado! Id:" + id + 
					 ", Tipo:" + Cliente.class.getName());
		});
	}
	
}
