package br.com.im.lojavirtualspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.im.lojavirtualspring.model.Pedido;
import br.com.im.lojavirtualspring.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidoController{
	
	@Autowired
	private PedidoRepository repository;
	
	@GetMapping("/findall")
	public List<Pedido> findAll(){
		return repository.findAll();
	}

}
