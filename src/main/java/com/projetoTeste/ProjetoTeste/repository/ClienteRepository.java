package com.projetoTeste.ProjetoTeste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoTeste.ProjetoTeste.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	

}
