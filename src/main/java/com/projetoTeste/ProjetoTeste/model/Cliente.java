package com.projetoTeste.ProjetoTeste.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.projetoTeste.ProjetoTeste.enums.Risco;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_cliente")

public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;

	@Size(max = 50)
	@Column(nullable = false, length = 50)
	private String nomeCliente;

	private String ValorTotal;

	private Double Valor;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 50)
	private Risco risco;

	public Cliente() {
	}

	public Cliente(String nomCliente, Double valor, Risco risco) {

		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		
		this.nomeCliente = nomCliente;

		if (risco.equals(Risco.RISCO_A)) {
			this.ValorTotal =  nf.format(new BigDecimal(valor));
		} else if (risco.equals(Risco.RISCO_B)) {
			this.ValorTotal = nf.format(new BigDecimal(valor + ((valor * 10) / 100)));
		} else if (risco.equals(Risco.RISCO_C)) {
			this.ValorTotal =  nf.format(new BigDecimal(valor + ((valor * 20) / 100)));
		}
		this.Valor = valor;
		this.risco = risco;
		
	}

}
