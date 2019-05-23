package br.com.im.lojavirtualspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.im.lojavirtualspring.model.Reposicao;

@Repository
public interface ReposicaoRepository extends CrudRepository<Reposicao, Long>{
	
}
