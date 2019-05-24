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
@Table(name = "item_reposicao")
public class ItemReposicao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -73052732527367028L;
	
	@Id
	@SequenceGenerator(name = "item_reposicao_seq", sequenceName = "item_reposicao_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_reposicao_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "produto_id", nullable = false , foreignKey=@ForeignKey(name="ir_produto_id"))
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "reposicao_id", nullable = false , foreignKey=@ForeignKey(name="ir_reposicao_id"))
	@JsonBackReference
	private Reposicao reposicao;
	
	@Column
	private Long quantidade;

	public ItemReposicao() {
	}

	public ItemReposicao(Long id, Produto produto, Reposicao reposicao, Long quantidade) {
		super();
		this.id = id;
		this.produto = produto;
		this.reposicao = reposicao;
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

	public Reposicao getReposicao() {
		return reposicao;
	}

	public void setReposicao(Reposicao reposicao) {
		this.reposicao = reposicao;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

}
