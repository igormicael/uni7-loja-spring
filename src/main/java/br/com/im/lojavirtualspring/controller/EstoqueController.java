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

import br.com.im.lojavirtualspring.model.Estoque;
import br.com.im.lojavirtualspring.service.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

	@Autowired
	private EstoqueService service;

	@GetMapping("/findAll")
	public List<Estoque> findAll() {
		return service.findAll();
	}

	@GetMapping("/")
	public ResponseEntity<?> findAtivo() {
		Estoque estoque = null;

		try {
			estoque = service.findAtivo();
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Estoque>(estoque, HttpStatus.OK);
	}

	@GetMapping("/produto/{id}")
	public ResponseEntity<?> findByProdutoId(@PathVariable("id") Long idProduto) {

		Estoque estoque = null;

		try {
			estoque = service.findByProdutoId(idProduto);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Estoque>(estoque, HttpStatus.OK);

	}

	@PostMapping("/produto/{id}/aumentar/{quantidade}")
	public ResponseEntity<?> adicionarProduto(@PathVariable("id") Long idProduto,
			@PathVariable("quantidade") Long quantidade) {
		Estoque estoque = null;

		try {
			estoque = service.adicionarProduto(idProduto, quantidade);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Estoque>(estoque, HttpStatus.OK);
	}

	@PostMapping("/produto/{id}/diminuir/{quantidade}")
	public ResponseEntity<?> diminuirProduto(@PathVariable("id") Long idProduto,
			@PathVariable("quantidade") Long quantidade) {
		Estoque estoque = null;

		try {
			estoque = service.diminuirProduto(idProduto, quantidade);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Estoque>(estoque, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Estoque findById(@PathVariable("id") Long id) {
		return service.findById(id).orElse(null);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		service.deleteById(id);
	}

	@PostMapping
	public void save(@RequestBody Estoque estoque) {
		service.save(estoque);
	}

	@PutMapping
	public void update(@RequestBody Estoque estoque) {
		service.update(estoque);
	}

}
