package br.com.im.lojavirtualspring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="reposicao")
public class Reposicao {

	@Id
	@SequenceGenerator(name = "reposicao_seq", sequenceName = "reposical_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reposicao_seq")
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "reposicao", fetch = FetchType.LAZY)
	private List<ItemReposicao> itens;
	
	@Enumerated(EnumType.STRING)
	private StatusAndamento status;

	public Reposicao() {
		super();
	}

	public Reposicao(Long id, List<ItemReposicao> itens, StatusAndamento status) {
		super();
		this.id = id;
		this.itens = itens;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ItemReposicao> getItens() {
		return itens;
	}

	public void setItens(List<ItemReposicao> itens) {
		this.itens = itens;
	}

	public StatusAndamento getStatus() {
		return status;
	}

	public void setStatus(StatusAndamento status) {
		this.status = status;
	}

	public void addItem(ItemReposicao item) {
		if(itens == null) {
			itens = new ArrayList<>();
		}
		
		if(!itens.contains(item)) {
			itens.add(item);
		}
		
	}
	
}
