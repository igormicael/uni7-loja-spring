package br.com.im.lojavirtualspring.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.im.lojavirtualspring.model.Estoque;

@Repository
public interface EstoqueRepository extends CrudRepository<Estoque, Long> {

	Optional<Estoque> findByAtivo(Boolean ativo);
	
}