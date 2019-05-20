package br.com.im.lojavirtualspring.model;

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
	
	//TODO: estruturar melhor a ligação de reposicao com item
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pedido", fetch = FetchType.LAZY)
	private List<Item> itens;
	
	@Enumerated(EnumType.STRING)
	private StatusAndamento status;

	public Reposicao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reposicao(Long id, List<Item> itens, StatusAndamento status) {
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

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public StatusAndamento getStatus() {
		return status;
	}

	public void setStatus(StatusAndamento status) {
		this.status = status;
	}
	
}
