package br.com.im.lojavirtualspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/reposicoes")
public class ReposicaoController {

	@Autowired
	private ReposicaoService service;
	
	@GetMapping()
	public List<Reposicao> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		Reposicao reposicao = null;
		
		try {
			reposicao = service.findById(id);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Reposicao>(reposicao, HttpStatus.OK);
		
	}

	@PutMapping("{id}/cancelar")
	public ResponseEntity<?> cancelarReposicao(@PathVariable("id") Long id) {
		{
			Reposicao reposicao = null;
			
			try {
				reposicao = service.cancelarReposicao(id);
			} catch (Exception e) {
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			return new ResponseEntity<Reposicao>(reposicao, HttpStatus.OK);
			
		}
	}
	
	@PutMapping("{id}/processar")
	public ResponseEntity<?> processarReposicao(@PathVariable("id") Long id) {
		{
			Reposicao reposicao = null;
			
			try {
				reposicao = service.processarReposicao(id);
			} catch (Exception e) {
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			return new ResponseEntity<Reposicao>(reposicao, HttpStatus.OK);
			
		}
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
