package br.com.im.lojavirtualspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.im.lojavirtualspring.model.Produto;
import br.com.im.lojavirtualspring.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	public Optional<Produto> findById(Long id) {
		return this.repository.findById(id);
	}

	public List<Produto> findAll() {
		return (List<Produto>) this.repository.findAll();
	}

	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}

	public void save(Produto produto) {
		this.repository.save(produto);
	}

	public void update(Produto produto) {
		this.repository.save(produto);
	}

	public void deleteAll() {
		this.repository.deleteAll();
	}

}
