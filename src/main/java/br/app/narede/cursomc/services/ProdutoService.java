package br.app.narede.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.app.narede.cursomc.domain.Categoria;
import br.app.narede.cursomc.domain.Produto;
import br.app.narede.cursomc.repositories.CategoriaRepository;
import br.app.narede.cursomc.repositories.ProdutoRepository;
import br.app.narede.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepo;
	
	@Autowired
	private CategoriaRepository categoriaRepo;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = produtoRepo.findById(id);
		return obj.orElseThrow(()->{
			 return new ObjectNotFoundException("Objeto não encontrado! Id:" + id + 
					 ", Tipo:" + Produto.class.getName());
		});
	}
	
	
	public Page<Produto> search(String nome, 
								List<Integer> ids, 
								Integer page, 
								Integer linesPerPage, 
								String orderBy, 
								String direction) {
		
		PageRequest pageRequest  = PageRequest.of(page, 
												  linesPerPage, 
												  Direction.valueOf(direction), 
												  orderBy);
		
		List<Categoria> categorias = categoriaRepo.findAllById(ids);
		
		return produtoRepo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}
	
}
