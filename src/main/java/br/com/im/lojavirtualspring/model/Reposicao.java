package br.com.im.lojavirtualspring.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="reposicao")
public @Data class Reposicao {

	@Id
	@SequenceGenerator(name = "reposicao_seq", sequenceName = "reposical_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reposicao_seq")
	private Long id;
	
	//TODO: estruturar melhor a ligação de reposicao com item
//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pedido", fetch = FetchType.LAZY)
//	private List<Item> itens;
	
	@Enumerated(EnumType.STRING)
	private StatusAndamento status;
	
}
