package br.app.narede.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.narede.cursomc.domain.Categoria;
import br.app.narede.cursomc.repositories.CategoriaRepository;
import br.app.narede.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(()->{
			 return new ObjectNotFoundException("Objecto não encontrado! Id:" + id + 
					 ", Tipo:" + Categoria.class.getName());
		});
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
}
