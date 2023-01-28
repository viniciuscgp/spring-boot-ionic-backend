package br.app.narede.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.narede.cursomc.domain.Pedido;
import br.app.narede.cursomc.repositories.PedidoRepository;
import br.app.narede.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(()->{
			 return new ObjectNotFoundException("Objeto não encontrado! Id:" + id + 
					 ", Tipo:" + Pedido.class.getName());
		});
	}
	
}
