package br.com.im.lojavirtualspring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	@JoinColumn(name="cliente_id", nullable = false, foreignKey=@ForeignKey(name="cliente_id"))
	@JsonBackReference
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Item> itens;
	
	public Pedido() {
		super();
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
