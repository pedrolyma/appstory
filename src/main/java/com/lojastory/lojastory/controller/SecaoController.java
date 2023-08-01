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

import com.lojastory.lojastory.entities.SecaoModel;
import com.lojastory.lojastory.repositories.SecaoRepository;
import com.lojastory.lojastory.services.SecaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/secoes")
public class SecaoController {

	@Autowired
	private SecaoRepository secaoRepository;
	
	@Autowired
	private SecaoService secaoService;
	
    @GetMapping
    public Page<SecaoModel> findAll(@RequestParam int page, @RequestParam int size) {
        PageRequest paginasecao = PageRequest.of(page,size);
        return secaoRepository.findAll(paginasecao);
    }

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SecaoModel criar(@RequestBody @Valid SecaoModel secaoModel) {
		return secaoService.salvar(secaoModel);
	}
	
	@GetMapping("/{SecaoId}")
    public ResponseEntity<SecaoModel> buscarPorId(@PathVariable Long SecaoId) {
    	return secaoRepository.findById(SecaoId)
    			.map(ResponseEntity::ok)
    			.orElse(ResponseEntity.notFound().build());
    }
	
    @PutMapping("/{SecaoId}")
	public ResponseEntity<SecaoModel> atualizar(@Valid @PathVariable Long SecaoId, @RequestBody SecaoModel secao) {
		if (!secaoRepository.existsById(SecaoId)) {
			return ResponseEntity.notFound().build();
		}
		secao.setIdsecao(SecaoId);
		secao = secaoService.salvar(secao);
		return ResponseEntity.ok(secao);
	}
    
    @PutMapping("/{codigo}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPropriedadeAtivo(@PathVariable long codigo, @RequestBody Boolean ativo) {
        secaoService.atualizaPropriedadeAtivo(codigo, ativo);  	
    }
}
