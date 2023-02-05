package br.app.narede.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.app.narede.cursomc.domain.Categoria;
import br.app.narede.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
// Utilizando consulta personalizada:	
//	@Query("SELECT DISTINCT p FROM produtos p INNER JOIN p.categorias cat WHERE p.nome LIKE %:nome% AND cat IN :categorias")
//	Page<Produto> search(@Param("nome") String nome, 
//			 			 @Param("categorias") List<Categoria>categorias, 
//			 			 Pageable pageRequest);
	@Transactional(readOnly = true)
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(
						 String nome, 
			 			 List<Categoria>categorias, 
			 			 Pageable pageRequest);
}

