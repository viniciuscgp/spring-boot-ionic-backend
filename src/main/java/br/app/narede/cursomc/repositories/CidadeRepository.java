package br.app.narede.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.narede.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{
	
}
