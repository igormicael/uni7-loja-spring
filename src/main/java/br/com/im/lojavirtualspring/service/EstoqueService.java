package br.com.im.lojavirtualspring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.im.lojavirtualspring.model.Estoque;
import br.com.im.lojavirtualspring.model.ItemEstoque;
import br.com.im.lojavirtualspring.model.Produto;
import br.com.im.lojavirtualspring.repository.EstoqueRepository;

@Service
public class EstoqueService {
	
	@Autowired
	private EstoqueRepository repository;
	
	@Autowired
	private ProdutoService produtoService;
	
	
	public Optional<Estoque> findById(Long id) {
		return this.repository.findById(id);
	}

	public List<Estoque> findAll() {
		return (List<Estoque>) this.repository.findAll();
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

	public Optional<Estoque> findAtivo() {
		return repository.findByAtivo(Boolean.TRUE);
	}

	public Estoque findByProdutoId(Long idProduto) throws Exception {
		Estoque estoque = recuperarEstoqueAtivo();
		
		ItemEstoque item = recuperarItemPeloProduto(estoque, idProduto);
		
		estoque.setItens(new ArrayList<>());
		estoque.addItemEstoque(item);
		
		return estoque;
	}

	public Estoque adicionarProduto(Long idProduto, Long quantidade) throws Exception {
		Estoque estoque = recuperarEstoqueAtivo();
		
		ItemEstoque item = recuperarItemPeloProduto(estoque, idProduto);
		
		item.adicionarQuantidade(quantidade);
		
		return repository.save(estoque);
	}

	public Estoque diminuirProduto(Long idProduto, Long quantidade) throws Exception {
		Estoque estoque = recuperarEstoqueAtivo();
		
		ItemEstoque item = recuperarItemPeloProduto(estoque, idProduto);
		
		item.diminuirQuantidade(quantidade);
		
		return repository.save(estoque);
	}
	
	
	private Estoque recuperarEstoqueAtivo() throws Exception {
		Estoque estoque = repository.findByAtivo(Boolean.TRUE).orElse(null);
		
		if(estoque == null) {
			throw new Exception("Não existe estoque ativo no momento");
		}
		
		return estoque;
	}

	private ItemEstoque recuperarItemPeloProduto(Estoque estoque, Long idProduto) throws Exception {
		
		Produto produto = produtoService.findById(idProduto).orElse(null);
		
		if(produto == null) {
			throw new Exception("Não existe produto com esse codigo");
		}
		
		if(estoque.getItens() != null ) {
			for (ItemEstoque itemEstoque : estoque.getItens()) {
				if(itemEstoque.getProduto().equals(produto)) {
					return itemEstoque;
				}
			}
		}
		return null;
	}

}
