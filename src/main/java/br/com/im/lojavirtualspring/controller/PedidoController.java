package br.com.im.lojavirtualspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public Pedido findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		service.deleteById(id);
	}

	@PostMapping
	public ResponseEntity<Pedido> save(@RequestBody Pedido pedido) {
		return new ResponseEntity<Pedido>(service.save(pedido), HttpStatus.OK);
	}

	@PostMapping("/{id}/adicionar-produto/{idProduto}/quantidade/{quantidade}")
	public ResponseEntity<?> adicionarProduto(@PathVariable("id") Long id, @PathVariable("idProduto") Long idProduto,
			@PathVariable("quantidade") Long quantidade) {
		Pedido adicionarProduto = null;

		try {
			adicionarProduto = service.adicionarProduto(id, idProduto, quantidade);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Pedido>(adicionarProduto, HttpStatus.OK);
	}

	@PostMapping("/{id}/remover-produto/{idProduto}/quantidade/{quantidade}")
	public ResponseEntity<?> removerProduto(@PathVariable("id") Long id, @PathVariable("idProduto") Long idProduto,
			@PathVariable("quantidade") Long quantidade) {
		Pedido removerProduto = null;

		try {
			removerProduto = service.removerProduto(id, idProduto, quantidade);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Pedido>(removerProduto, HttpStatus.OK);
	}

	@PutMapping
	public void update(@RequestBody Pedido pedido) {
		service.update(pedido);
	}

}
