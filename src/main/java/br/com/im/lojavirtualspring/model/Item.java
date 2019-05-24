package br.com.im.lojavirtualspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "item")
public class Item {

	@Id
	@SequenceGenerator(name = "item_seq", sequenceName = "item_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="produto_id", nullable = false , foreignKey=@ForeignKey(name="item_produto_id"))
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name="pedido_id", nullable = false , foreignKey=@ForeignKey(name="item_pedido_id"))
	@JsonBackReference
	private Pedido pedido;
	
	@Column
	private Long quantidade;

	public Item() {
		super();
	}

	public Item(Long id, Pedido pedido, Produto produto) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.produto = produto;
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

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}

	public void adicionarQuantidade(Long quantidade) {
		this.quantidade += quantidade;
	}
	
	public void diminuirQuantidade(Long quantidade) {
		this.quantidade -= quantidade;
	}
	
}
