package com.lojastory.lojastory.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lojastory.lojastory.entities.SecaoModel;
import com.lojastory.lojastory.exception.NegocioException;
import com.lojastory.lojastory.repositories.SecaoRepository;

@Service
public class SecaoService {

	@Autowired
	private SecaoRepository secaoRepository;
	
	@Transactional
	public SecaoModel salvar(SecaoModel secao) {
		boolean secaoEmUso = secaoRepository.findBydescricaosecao(secao.getDescricaosecao()).stream()
				.anyMatch(secaoExistente -> !secaoExistente.equals(secao));
		if (secaoEmUso) {
			throw new NegocioException("Seção Ja Cadastrada na Base de Dados");
		}
		return secaoRepository.save(secao);
	}
	
	@Transactional
	public void atualizaPropriedadeAtivo(long codigo, Boolean ativo) {
		SecaoModel secaoSalva = buscarPeloId(codigo);
		secaoSalva.setStatussecao(ativo);
		secaoRepository.save(secaoSalva);
	}

	public SecaoModel buscarPeloId(Long codigo) {
		Optional<SecaoModel> secaoSalva = secaoRepository.findById(codigo);
		if (secaoSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return secaoSalva.orElseThrow();
	}
}
