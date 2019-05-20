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

import br.com.im.lojavirtualspring.model.Reposicao;
import br.com.im.lojavirtualspring.service.ReposicaoService;

@RestController
@RequestMapping("/reposicaos")
public class ReposicaoController {

	@Autowired
	private ReposicaoService service;

	@GetMapping("/{id}")
	public Reposicao findById(@PathParam("id") Long id) {
		return service.findById(id);
	}

	@GetMapping("/findall")
	public List<Reposicao> findAll() {
		return service.findAll();
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathParam("id") Long id) {
		service.deleteById(id);
	}

	@PostMapping
	public void save(Reposicao reposicao) {
		service.save(reposicao);
	}

	@PutMapping
	public void update(Reposicao reposicao) {
		service.update(reposicao);
	}

}
