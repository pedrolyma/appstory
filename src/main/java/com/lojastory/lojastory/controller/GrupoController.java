package com.lojastory.lojastory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

import com.lojastory.lojastory.entities.GrupoModel;
import com.lojastory.lojastory.repositories.GrupoRepository;
import com.lojastory.lojastory.services.GrupoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/grupos")
public class GrupoController {

	@Autowired
	private GrupoRepository grupoRepository;

	@Autowired
	private GrupoService grupoService;

    @GetMapping
    public Page<GrupoModel> findAll(@RequestParam int page, @RequestParam int size) {
        PageRequest paginagrupos = PageRequest.of(page,size);
        return grupoRepository.findAll(paginagrupos);
    }

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public GrupoModel criar(@RequestBody @Valid GrupoModel grupoModel) {
		return grupoService.salvar(grupoModel);
		/*
		 * MarcaModel marcaModel = marcaRequest.converter(marcaRepository); MarcaModel
		 * marcaSalva = marcaRepository.save(marcaModel);
		 * 
		 * URI uri =
		 * ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{IdMarca}")
		 * .buildAndExpand(marcaSalva.getIdMarca()).toUri();
		 * response.setHeader("Location", uri.toASCIIString()); return
		 * ResponseEntity.created(uri).body(new MarcaDTO(marcaSalva));
		 */
	}
	
	@GetMapping("/{GrupoId}")
    public ResponseEntity<GrupoModel> buscarPorId(@PathVariable Long GrupoId) {
    	return grupoRepository.findById(GrupoId)
    			.map(ResponseEntity::ok)
    			.orElse(ResponseEntity.notFound().build());
    }
	
    @PutMapping("/{GrupoId}")
	public ResponseEntity<GrupoModel> atualizar(@Valid @PathVariable Long GrupoId, @RequestBody GrupoModel grupo) {
		if (!grupoRepository.existsById(GrupoId)) {
			return ResponseEntity.notFound().build();
		}
		grupo.setIdgrupo(GrupoId);
		grupo = grupoService.salvar(grupo);
		return ResponseEntity.ok(grupo);
	}
    
    @PutMapping("/{codigo}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPropriedadeAtivo(@PathVariable long codigo, @RequestBody Boolean ativo) {
        grupoService.atualizaPropriedadeAtivo(codigo, ativo);  	
    }
    
}
