package com.lojastory.lojastory.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lojastory.lojastory.entities.AgendaModel;
import com.lojastory.lojastory.exception.NegocioException;
import com.lojastory.lojastory.repositories.AgendaRepository;

@Service
public class AgendaService {
	
	@Autowired
	private AgendaRepository agendaRepository;
	
	@Transactional
	public AgendaModel salvar(AgendaModel agenda) {
		boolean agendaEmUso = agendaRepository.findBynomeagenda(agenda.getNomeagenda()).stream()
				.anyMatch(agendaExistente -> !agendaExistente.equals(agenda));
		if (agendaEmUso) {
			throw new NegocioException("Agenda Ja Cadastrada na Base de Dados");
		}
		return agendaRepository.save(agenda);
	}
	
}
