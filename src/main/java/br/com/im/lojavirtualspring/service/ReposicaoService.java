package br.com.im.lojavirtualspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.im.lojavirtualspring.model.ItemReposicao;
import br.com.im.lojavirtualspring.model.Produto;
import br.com.im.lojavirtualspring.model.Reposicao;
import br.com.im.lojavirtualspring.model.StatusAndamento;
import br.com.im.lojavirtualspring.repository.ReposicaoRepository;

@Service
public class ReposicaoService {
	
	@Autowired
	private ReposicaoRepository repository;
	
	public Reposicao findById(Long id) {
		return this.repository.findById(id).get();
	}

	public List<Reposicao> findAll() {
		return (List<Reposicao>) this.repository.findAll();
	}

	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}

	public void save(Reposicao reposicao) {
		this.repository.save(reposicao);
	}

	public void update(Reposicao reposicao) {
		this.repository.save(reposicao);
	}

	public void deleteAll() {
		this.repository.deleteAll();
	}

	public void solicitarReposicao(Produto produto, Long quantidadeReposicao) {
		
		Reposicao reposicao = new Reposicao();
		reposicao.setStatus(StatusAndamento.PENDENTE);
		
		ItemReposicao item = new ItemReposicao();
		item.setReposicao(reposicao);
		item.setProduto(produto);
		item.setQuantidade(quantidadeReposicao);
		
		reposicao.addItem(item);
		
		this.repository.save(reposicao);
	}

}
