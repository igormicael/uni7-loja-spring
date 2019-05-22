package br.com.im.lojavirtualspring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.im.lojavirtualspring.model.Produto;
import br.com.im.lojavirtualspring.model.Reposicao;

@Repository
public interface ReposicaoRepository extends JpaRepository<Reposicao, Long>{
	
	Optional<Reposicao> findById(Long id);
	List<Reposicao> findAll();
	void solicitarReposicao(Produto produto, Long quantidadeReposicao);

}
