package br.com.im.lojavirtualspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.im.lojavirtualspring.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{}
