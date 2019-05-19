package br.com.im.lojavirtualspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.im.lojavirtualspring.model.Pedido;
import br.com.im.lojavirtualspring.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public Pedido findById(Long id) {
		return this.repository.findById(id).get();
	}

	public List<Pedido> findAll() {
		return this.repository.findAll();
	}

	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}

	public void save(Pedido pedido) {
		this.repository.save(pedido);
	}

	public void update(Pedido pedido) {
		this.repository.save(pedido);
	}

	public void deleteAll() {
		this.repository.deleteAll();
	}

}
