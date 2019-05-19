package br.com.im.lojavirtualspring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.im.lojavirtualspring.model.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long>{
	
	Optional<Estoque> findById(Long id);
	List<Estoque> findAll();

}
