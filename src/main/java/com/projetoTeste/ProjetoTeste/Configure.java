package com.projetoTeste.ProjetoTeste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.projetoTeste.ProjetoTeste.enums.Risco;
import com.projetoTeste.ProjetoTeste.model.Cliente;
import com.projetoTeste.ProjetoTeste.service.ClienteService;

@Configuration
public class Configure implements CommandLineRunner {
	
	
	@Autowired
	private ClienteService init;
	@Override
	public void run(String... args) throws Exception {
		
		init.salvarCliente(new Cliente("RAFAEL NOBERTO", 50.00, Risco.RISCO_B));
		init.salvarCliente(new Cliente("THAIS MOREIRA", 50.00, Risco.RISCO_C));
		init.salvarCliente(new Cliente("LUOURDES MOREIRA", 50.00, Risco.RISCO_A));
	}

}
