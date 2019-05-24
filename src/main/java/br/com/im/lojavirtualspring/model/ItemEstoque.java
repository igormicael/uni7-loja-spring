package br.com.im.lojavirtualspring.model;

import java.io.Serializable;

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
@Table(name = "item_estoque")
public class ItemEstoque implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6106371944829233848L;

	@Id
	@SequenceGenerator(name = "item_estoque_seq", sequenceName = "item_estoque_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_estoque_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "produto_id", nullable = false , foreignKey=@ForeignKey(name="ie_produto_id"))
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "estoque_id", nullable = false, foreignKey=@ForeignKey(name="ie_estoque_id"))
	@JsonBackReference
	private Estoque estoque;

	@Column
	private Long quantidade;

	public ItemEstoque() {
	}

	public ItemEstoque(Long id, Produto produto, Estoque estoque, Long quantidade) {
		super();
		this.id = id;
		this.produto = produto;
		this.estoque = estoque;
		this.quantidade = quantidade;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	
	public void adicionarQuantidade(Long quantidade) {
		this.quantidade += quantidade;
	}
	
	public void diminuirQuantidade(Long quantidade) {
		this.quantidade -= quantidade;
	}

}
