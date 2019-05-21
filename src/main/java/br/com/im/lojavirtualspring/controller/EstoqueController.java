package br.com.im.lojavirtualspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping()
	public List<Estoque> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Estoque findById(@PathVariable("id") Long id) {
		return service.findById(id);
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
