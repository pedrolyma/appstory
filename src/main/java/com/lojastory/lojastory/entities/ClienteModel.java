package com.lojastory.lojastory.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_Cliente")
public class ClienteModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idcliente;
	private String nomecliente;
	private String cpfcliente;
	private String rgcliente;
	private LocalDate nascimento;
	private String telefone;
	private String email;
	private String instagran;
	private String cep;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String estado;
	private String trabalha;
	private LocalDate datacadastro;
	private String pai;
	private String mae;
	private String natural;
	
	

}
