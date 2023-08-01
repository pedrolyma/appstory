package com.lojastory.lojastory.controller;

import java.util.List;

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

import com.lojastory.lojastory.entities.MarcaModel;
import com.lojastory.lojastory.repositories.MarcaRepository;
import com.lojastory.lojastory.services.MarcaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

	@Autowired
	private MarcaRepository marcaRepository;
	
	@Autowired
	private MarcaService marcaService;
	
    @GetMapping
    public Page<MarcaModel> findAll(@RequestParam int page, @RequestParam int size) {
        PageRequest paginamarcas = PageRequest.of(page,size);
        return marcaRepository.findAll(paginamarcas);
    }
    
    @GetMapping("/{todas}")
    public List<MarcaModel> findAll() {
        return marcaRepository.findAll();
    }
	
	@GetMapping("/{MarcaId}")
    public ResponseEntity<MarcaModel> buscarPorId(@PathVariable Long MarcaId) {
    	return marcaRepository.findById(MarcaId)
    			.map(ResponseEntity::ok)
    			.orElse(ResponseEntity.notFound().build());
    }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MarcaModel criar(@RequestBody @Valid MarcaModel marcaModel) {
		return marcaService.salvar(marcaModel);
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
	
    @PutMapping("/{MarcaId}")
	public ResponseEntity<MarcaModel> atualizar(@Valid @PathVariable Long MarcaId, @RequestBody MarcaModel marca) {
		if (!marcaRepository.existsById(MarcaId)) {
			return ResponseEntity.notFound().build();
		}
		marca.setIdmarca(MarcaId);
		marca = marcaService.salvar(marca);
		return ResponseEntity.ok(marca);
	}
    
    @PutMapping("/{codigo}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPropriedadeAtivo(@PathVariable long codigo, @RequestBody Boolean ativo) {
        marcaService.atualizaPropriedadeAtivo(codigo, ativo);  	
    }
}
 