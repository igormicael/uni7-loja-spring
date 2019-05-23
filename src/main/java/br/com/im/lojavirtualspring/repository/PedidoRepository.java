package br.com.im.lojavirtualspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.im.lojavirtualspring.model.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long>{}