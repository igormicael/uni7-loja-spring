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
	
	@Autowired
	private EstoqueService estoqueService;

	public Reposicao findById(Long id) throws Exception {

		Reposicao reposicao = this.repository.findById(id).orElse(null);

		if (reposicao == null)
			throw new Exception("Reposicão não encontrada!");

		return reposicao;
	}

	public List<Reposicao> findAll() {
		return (List<Reposicao>) this.repository.findAll();
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

	public Reposicao cancelarReposicao(Long id) throws Exception {

		Reposicao reposicao = findById(id);

		if (reposicao.getStatus() != null && reposicao.getStatus().equals(StatusAndamento.PENDENTE))
			reposicao.setStatus(StatusAndamento.PENDENTE);

		return repository.save(reposicao);
	}

	public Reposicao processarReposicao(Long id) throws Exception {
		
		Reposicao reposicao = findById(id);
		
		if (reposicao.getStatus() != null && !reposicao.getStatus().equals(StatusAndamento.PENDENTE))
			throw new Exception("Só é possivel processar reposicoes pendentes.");
		
		estoqueService.reporEstoque(reposicao.getItens());
		
		reposicao.setStatus(StatusAndamento.PROCESSADO);
		
		
		return repository.save(reposicao);
	}

}
