package br.com.im.lojavirtualspring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {

	@Id
	@SequenceGenerator(name = "item_seq", sequenceName = "item_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="pedido_id", nullable = false)
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name="produto_id", nullable = false)
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name="estoque_id", nullable = false)
	private Estoque estoque;

	public Item() {
		super();
	}

	public Item(Long id, Pedido pedido, Produto produto, Estoque estoque) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.produto = produto;
		this.estoque = estoque;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
}