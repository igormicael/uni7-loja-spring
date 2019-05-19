package br.com.im.lojavirtualspring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.im.lojavirtualspring.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	Optional<Produto> findById(Long id);
	List<Produto> findAll();

}
