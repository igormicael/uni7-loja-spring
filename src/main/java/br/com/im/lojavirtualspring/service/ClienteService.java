package br.com.im.lojavirtualspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.im.lojavirtualspring.model.Cliente;
import br.com.im.lojavirtualspring.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public Cliente findById(Long id) {
		return this.repository.findById(id).get();
	}

	public List<Cliente> findAll() {
		return (List<Cliente>) this.repository.findAll();
	}

	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}

	public void save(Cliente cliente) {
		this.repository.save(cliente);
	}

	public void update(Cliente cliente) {
		this.repository.save(cliente);
	}

	public void deleteAll() {
		this.repository.deleteAll();
	}

}
