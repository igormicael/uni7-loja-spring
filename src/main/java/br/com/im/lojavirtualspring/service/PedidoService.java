package br.com.im.lojavirtualspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.im.lojavirtualspring.model.Estoque;
import br.com.im.lojavirtualspring.model.Item;
import br.com.im.lojavirtualspring.model.ItemEstoque;
import br.com.im.lojavirtualspring.model.Pedido;
import br.com.im.lojavirtualspring.model.Produto;
import br.com.im.lojavirtualspring.model.StatusAndamento;
import br.com.im.lojavirtualspring.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private EstoqueService estoqueService;
	
	@Autowired
	private ReposicaoService reposicaoService;

	public Pedido findById(Long id) {
		return this.repository.findById(id).get();
	}

	public List<Pedido> findAll() {
		return this.repository.findAll();
	}

	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}

	public Pedido save(Pedido pedido) {
		return this.repository.save(pedido);
	}

	public void update(Pedido pedido) {
		this.repository.save(pedido);
	}

	public void deleteAll() {
		this.repository.deleteAll();
	}

	public Pedido adicionarProduto(Long id, Long idProduto, Long quantidade) throws Exception {
		Pedido pedido = repository.findById(id).orElse(null);
		Produto produto = produtoService.findById(idProduto).orElse(null);

		if(pedido == null)
			throw new Exception("Pedido não encontrado no sistema");
		
		if(produto == null)
			throw new Exception("Produto não encontrado no sistema");
		
		Item item = new Item();
		item.setPedido(pedido);
		item.setProduto(produto);
		item.setQuantidade(quantidade);

		pedido.adicionarItem(item);

		return save(pedido);
	}

	public Pedido removerProduto(Long id, Long idProduto, Long quantidade) throws Exception {
		Pedido pedido = repository.findById(id).orElse(null);
		Produto produto = produtoService.findById(idProduto).orElse(null);
		
		if(pedido == null)
			throw new Exception("Pedido não encontrado no sistema");
		
		if(produto == null)
			throw new Exception("Produto não encontrado no sistema");

		Item item = new Item();
		item.setPedido(pedido);
		item.setProduto(produto);
		item.setQuantidade(quantidade);

		pedido.removerItem(item);

		return save(pedido);
	}

	public Pedido finalizarPedido(Long id) throws Exception {
		//TODO: criar logica para trazer o estoque ativo
		Estoque estoque = estoqueService.findById(1L).orElse(null);
		
		Pedido pedido = repository.findById(id).orElse(null);
		
		if(pedido == null)
			throw new Exception("Pedido não encontrado no sistema");
		
		if(estoque == null ) {
			throw new Exception("Não existe estoque cadastrado");
		}
		
		List<Item> itens = pedido.getItens();
		List<ItemEstoque> itensEstoque = estoque.getItens();
		
		if(itensEstoque == null || itensEstoque.isEmpty()) {
			throw new Exception("Não existe estoque cadastrado");
		}
		
		if(itens == null || itens.isEmpty()) {
			throw new Exception("Não existem itens no pedido");
		}
		
		List<Item> itensFaltando = new ArrayList<>();
		List<Item> itensSemQuantidadeNecessaria = new ArrayList<>();
		List<ItemEstoque> itensEstoqueAlterados = new ArrayList<>();
		
		for (Item item : itens) {
			Produto produtoPedido = item.getProduto();
			
			ItemEstoque itemEstoque = verificaExistenciaEstoque(itensEstoque, produtoPedido);
			
			if(itemEstoque == null) {
				itensFaltando.add(item);
			}else {
				
				if(item.getQuantidade() > itemEstoque.getQuantidade()) {
					itensSemQuantidadeNecessaria.add(item);
				}else {
					itemEstoque.setQuantidade( itemEstoque.getQuantidade() - item.getQuantidade());
					itensEstoqueAlterados.add(itemEstoque);
				}
			}
		}
		
		if(!itensFaltando.isEmpty()) {
			throw new Exception(" existem produtos no pedido que não existem no estoque. favor entrar em contato com a central de atendimento ");
		}
		
		if(!itensSemQuantidadeNecessaria.isEmpty()) {
			
			pedido.setStatus(StatusAndamento.PENDENTE);
			
			for (Item item : itensSemQuantidadeNecessaria) {
				
				Long quantidadeReposicao = calcularQuantidadeReposicao(item);
				
				reposicaoService.solicitarReposicao(item.getProduto(), quantidadeReposicao);
			}
		}
		
		return null;
	}

	//TODO: implementar logica de verdade
	private Long calcularQuantidadeReposicao(Item item) {
		return 100L;
	}

	private ItemEstoque verificaExistenciaEstoque(List<ItemEstoque> itensEstoque, Produto produtoPedido) {
		for (ItemEstoque itemEstoque : itensEstoque) {
			if(produtoPedido.equals(itemEstoque.getProduto())) {
				return itemEstoque;
			}
		}
		
		return null;
	}

}
