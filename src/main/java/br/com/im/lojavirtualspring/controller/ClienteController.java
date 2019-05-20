package br.com.im.lojavirtualspring.controller;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.im.lojavirtualspring.model.Cliente;
import br.com.im.lojavirtualspring.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping("/{id}")
	public Cliente findById(@PathParam("id") Long id) {
		return service.findById(id);
	}

	@GetMapping("/findall")
	public List<Cliente> findAll() {
		return service.findAll();
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathParam("id") Long id) {
		service.deleteById(id);
	}

	@PostMapping
	public void save(Cliente cliente) {
		service.save(cliente);
	}

	@PutMapping
	public void update(Cliente cliente) {
		service.update(cliente);
	}

}
