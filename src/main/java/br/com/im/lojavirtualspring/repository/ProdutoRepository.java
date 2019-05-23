package br.com.im.lojavirtualspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.im.lojavirtualspring.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{}