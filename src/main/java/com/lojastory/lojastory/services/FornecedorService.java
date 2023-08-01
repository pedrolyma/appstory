package com.lojastory.lojastory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lojastory.lojastory.entities.FornecedorModel;
import com.lojastory.lojastory.exception.NegocioException;
import com.lojastory.lojastory.repositories.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Transactional
	public FornecedorModel salvar(FornecedorModel fornecedor) {
		boolean fornecedorEmUso = fornecedorRepository.findByrazaosocial(fornecedor.getRazaosocial())
				.stream()
				.anyMatch(fornecedorExistente -> !fornecedorExistente.equals(fornecedor));
		if (fornecedorEmUso) {
			throw new NegocioException("Fornecedor Ja Cadastrado na Base de Dados");
		}
		return fornecedorRepository.save(fornecedor);
	}
}
