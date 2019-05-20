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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {
	
	@Id
	@SequenceGenerator(name = "pedido_seq", sequenceName = "pedido_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_seq")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private StatusAndamento status;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pedido", fetch = FetchType.LAZY)
	private List<Item> itens;
	
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido(Long id, StatusAndamento status, Cliente cliente, List<Item> itens) {
		super();
		this.id = id;
		this.status = status;
		this.cliente = cliente;
		this.itens = itens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatusAndamento getStatus() {
		return status;
	}

	public void setStatus(StatusAndamento status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
}
