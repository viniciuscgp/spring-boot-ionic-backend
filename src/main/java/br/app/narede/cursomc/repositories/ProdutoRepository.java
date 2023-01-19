package br.app.narede.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.narede.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
}
