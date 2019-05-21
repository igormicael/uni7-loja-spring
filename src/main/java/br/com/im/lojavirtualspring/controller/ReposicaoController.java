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

import br.com.im.lojavirtualspring.model.Reposicao;
import br.com.im.lojavirtualspring.service.ReposicaoService;

@RestController
@RequestMapping("/reposicaos")
public class ReposicaoController {

	@Autowired
	private ReposicaoService service;
	
	@GetMapping()
	public List<Reposicao> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Reposicao findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		service.deleteById(id);
	}

	@PostMapping
	public void save(@RequestBody Reposicao reposicao) {
		service.save(reposicao);
	}

	@PutMapping
	public void update(@RequestBody Reposicao reposicao) {
		service.update(reposicao);
	}

}
