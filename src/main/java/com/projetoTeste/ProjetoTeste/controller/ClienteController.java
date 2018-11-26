package com.projetoTeste.ProjetoTeste.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoTeste.ProjetoTeste.model.Cliente;
import com.projetoTeste.ProjetoTeste.service.ClienteService;

/**
 * 
 * @author Rafael Noberto
 * 
 *
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")	
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/clientes")
	public List<Cliente> findAll() {

		return clienteService.findAll();
	}

	@PostMapping(value = "/clientes/criar")
	public Cliente salvarCliente(@RequestBody Cliente cliente) {

		
		Cliente cli = clienteService
				.salvarCliente(new Cliente(cliente.getNomeCliente().toUpperCase().trim(), cliente.getValor(), cliente.getRisco()));

		return cli;
	}
	
	
	
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<String> deleteCliente(@PathVariable("id") Integer id) {
 
		clienteService.deletar(id);
 
		return new ResponseEntity<>("Cliente deletado com Sucesso!!", HttpStatus.OK);
	}
	

	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
		Optional<Cliente> ClienteData = clienteService.listarPodId(id);
 
		if (ClienteData.isPresent()) {
			Cliente _Cliente = ClienteData.get();
			_Cliente.setNomeCliente(cliente.getNomeCliente());
			_Cliente.setRisco(cliente.getRisco());
			_Cliente.setValor(cliente.getValor());
			return new ResponseEntity<>(clienteService.salvarCliente(_Cliente), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	


}
