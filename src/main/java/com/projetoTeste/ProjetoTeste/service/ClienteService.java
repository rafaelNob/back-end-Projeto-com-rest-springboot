package com.projetoTeste.ProjetoTeste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoTeste.ProjetoTeste.enums.Risco;
import com.projetoTeste.ProjetoTeste.model.Cliente;
import com.projetoTeste.ProjetoTeste.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRespository;
	
	public Cliente salvarCliente(Cliente cliente) {
		
			
		
		return clienteRespository.save(cliente);
		
	}
	
	
	public List<Cliente> findAll() {
		
	
		return clienteRespository.findAll();
	}
	
	public void deletar(Integer id) {
		
		clienteRespository.deleteById(id);
	}
	
	public Optional<Cliente> listarPodId(Integer id) {
		
		 return clienteRespository.findById(id);
	}
}
