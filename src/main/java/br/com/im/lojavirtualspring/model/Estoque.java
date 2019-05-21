package br.com.im.lojavirtualspring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="estoque")
public class Estoque implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6848105760333570064L;

	@Id
	@SequenceGenerator(name = "estoque_seq", sequenceName = "estoque_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estoque_seq")
	private Long id;
	
	@OneToMany(mappedBy = "estoque", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<ItemEstoque> itens;
	
	public Estoque() {
		super();
	}

	public Estoque(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ItemEstoque> getItens() {
		return itens;
	}

	public void setItens(List<ItemEstoque> itens) {
		this.itens = itens;
	}

	public void addItemEstoque(ItemEstoque item) {
		if(itens == null) {
			itens = new ArrayList<>();
		}
		
		if(!itens.contains(item)) {
			itens.add(item);
		}
		
	}

}
