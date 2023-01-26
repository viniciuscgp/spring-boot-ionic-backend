package br.app.narede.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.narede.cursomc.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
}
