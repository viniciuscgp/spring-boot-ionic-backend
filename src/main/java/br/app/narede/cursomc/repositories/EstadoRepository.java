package br.app.narede.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.narede.cursomc.domain.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer>{
	
}
