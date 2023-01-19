package br.app.narede.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.narede.cursomc.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
	
}
