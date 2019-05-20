package br.com.im.lojavirtualspring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="estoque")
public class Estoque {
	
	@Id
	@SequenceGenerator(name = "estoque_seq", sequenceName = "estoque_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estoque_seq")
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pedido", fetch = FetchType.LAZY)
	private List<Item> itens;
	
	public Estoque() {
		super();
	}

	public Estoque(Long id, List<Item> itens) {
		super();
		this.id = id;
		this.itens = itens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

}
