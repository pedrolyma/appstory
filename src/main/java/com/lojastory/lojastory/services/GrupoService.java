package com.lojastory.lojastory.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lojastory.lojastory.entities.GrupoModel;
import com.lojastory.lojastory.exception.NegocioException;
import com.lojastory.lojastory.repositories.GrupoRepository;

@Service
public class GrupoService {

	@Autowired
	private GrupoRepository grupoRepository;

	@Transactional
	public GrupoModel salvar(GrupoModel grupo) {
		
		  GrupoModel grupoExiste = grupoRepository.findBydescricaogrupo(grupo.getDescricaogrupo());
		  if (grupoExiste != null && !grupoExiste.equals(grupo)) {
			  throw new NegocioException("Marca Ja Cadastrada na Base de Dados"); }
		 

			/*
			 * boolean grupoEmUso =
			 * grupoRepository.findBydescricaogrupo(grupo.getDescricaogrupo()).stream()
			 * .anyMatch(grupoExistente -> !grupoExistente.equals(grupo)); if (grupoEmUso) {
			 * throw new NegocioException("Grupo Ja Cadastrado na Base de Dados"); }
			 */
		return grupoRepository.save(grupo);
	}

	public void atualizaPropriedadeAtivo(long codigo, Boolean ativo) {
		GrupoModel grupoSalvo = buscarPeloId(codigo);
		grupoSalvo.setStatusgrupo(ativo);
		grupoRepository.save(grupoSalvo);
	}

	public GrupoModel buscarPeloId(Long codigo) {
		Optional<GrupoModel> grupoSalvo = grupoRepository.findById(codigo);
		if (grupoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return grupoSalvo.orElseThrow();
	}
}
