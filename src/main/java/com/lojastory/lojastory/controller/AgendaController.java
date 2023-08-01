package com.lojastory.lojastory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lojastory.lojastory.entities.AgendaModel;
import com.lojastory.lojastory.entities.GrupoModel;
import com.lojastory.lojastory.repositories.AgendaRepository;
import com.lojastory.lojastory.repositories.GrupoRepository;
import com.lojastory.lojastory.services.AgendaService;
import com.lojastory.lojastory.services.GrupoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/agendas")
public class AgendaController {
	
	@Autowired
	private AgendaRepository agendaRepository;

	@Autowired
	private AgendaService agendaService;

    @GetMapping
    public Page<AgendaModel> findAll(@RequestParam int page, @RequestParam int size) {
        PageRequest paginaagenda = PageRequest.of(page,size);
        return agendaRepository.findAll(paginaagenda);
    }

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AgendaModel criar(@RequestBody @Valid AgendaModel agendaModel) {
		return agendaService.salvar(agendaModel);
	}
	
	@GetMapping("/{AgendaId}")
    public ResponseEntity<AgendaModel> buscarPorId(@PathVariable Long AgendaId) {
    	return agendaRepository.findById(AgendaId)
    			.map(ResponseEntity::ok)
    			.orElse(ResponseEntity.notFound().build());
    }
	
    @PutMapping("/{AgendaId}")
	public ResponseEntity<AgendaModel> atualizar(@Valid @PathVariable Long AgendaId, @RequestBody AgendaModel agenda) {
		if (!agendaRepository.existsById(AgendaId)) {
			return ResponseEntity.notFound().build();
		}
		agenda.setIdagenda(AgendaId);
		agenda = agendaService.salvar(agenda);
		return ResponseEntity.ok(agenda);
	}
    
}
