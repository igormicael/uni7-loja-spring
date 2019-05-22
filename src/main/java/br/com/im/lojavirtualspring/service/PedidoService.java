package br.com.im.lojavirtualspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.im.lojavirtualspring.model.Item;
import br.com.im.lojavirtualspring.model.Pedido;
import br.com.im.lojavirtualspring.model.Produto;
import br.com.im.lojavirtualspring.repository.PedidoRepository;
import br.com.im.lojavirtualspring.repository.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	@Autowired
	private ProdutoRepository produtoRepository;

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
		Produto produto = produtoRepository.findById(idProduto).orElse(null);

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
		Produto produto = produtoRepository.findById(idProduto).orElse(null);
		
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

}
