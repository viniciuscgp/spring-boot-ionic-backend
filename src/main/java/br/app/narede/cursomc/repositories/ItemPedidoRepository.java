package br.app.narede.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.narede.cursomc.domain.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{
	
}
