package br.com.im.lojavirtualspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.im.lojavirtualspring.model.Estoque;
import br.com.im.lojavirtualspring.repository.EstoqueRepository;

@Service
public class EstoqueService {
	
	@Autowired
	private EstoqueRepository repository;
	
	public Estoque findById(Long id) {
		return this.repository.findById(id).get();
	}

	public List<Estoque> findAll() {
		return this.repository.findAll();
	}

	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}

	public void save(Estoque estoque) {
		this.repository.save(estoque);
	}

	public void update(Estoque estoque) {
		this.repository.save(estoque);
	}

	public void deleteAll() {
		this.repository.deleteAll();
	}

}
