package br.app.narede.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.narede.cursomc.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
}
