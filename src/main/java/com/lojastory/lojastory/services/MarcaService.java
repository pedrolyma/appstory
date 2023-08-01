package com.lojastory.lojastory.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lojastory.lojastory.entities.GrupoModel;
import com.lojastory.lojastory.entities.MarcaModel;
import com.lojastory.lojastory.exception.NegocioException;
import com.lojastory.lojastory.repositories.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository marcaRepository;

	@Transactional
	public MarcaModel salvar(MarcaModel marca) {
		boolean marcaEmUso = marcaRepository.findBydescricaomarca(marca.getDescricaomarca()).stream()
				.anyMatch(marcaExistente -> !marcaExistente.equals(marca));
		if (marcaEmUso) {
			throw new NegocioException("Marca Ja Cadastrada na Base de Dados");
		}
		return marcaRepository.save(marca);
	}
	
	public void atualizaPropriedadeAtivo(long codigo, Boolean ativo) {
		MarcaModel marcaSalva = buscarPeloId(codigo);
		marcaSalva.setStatusmarca(ativo);
		marcaRepository.save(marcaSalva);
	}

	public MarcaModel buscarPeloId(Long codigo) {
		Optional<MarcaModel> marcaSalvo = marcaRepository.findById(codigo);
		if (marcaSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return marcaSalvo.orElseThrow();
	}
}
