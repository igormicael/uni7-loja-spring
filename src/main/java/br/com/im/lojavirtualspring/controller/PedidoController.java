package br.com.im.lojavirtualspring.controller;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.im.lojavirtualspring.model.Pedido;
import br.com.im.lojavirtualspring.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService service;
	
	@GetMapping()
	public List<Pedido> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Pedido findById(@PathParam("id") Long id) {
		return service.findById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathParam("id") Long id) {
		service.deleteById(id);
	}

	@PostMapping
	public void save(@RequestBody Pedido pedido) {
		service.save(pedido);
	}

	@PutMapping
	public void update(@RequestBody Pedido pedido) {
		service.update(pedido);
	}

}
