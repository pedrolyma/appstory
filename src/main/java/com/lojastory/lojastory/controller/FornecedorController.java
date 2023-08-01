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

import com.lojastory.lojastory.entities.FornecedorModel;
import com.lojastory.lojastory.repositories.FornecedorRepository;
import com.lojastory.lojastory.services.FornecedorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private FornecedorService fornecedorService;
	
    @GetMapping
    public Page<FornecedorModel> findAll(@RequestParam int page, @RequestParam int size) {
        PageRequest paginafornecedor = PageRequest.of(page,size);
        return fornecedorRepository.findAll(paginafornecedor);
    }

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FornecedorModel criar(@RequestBody @Valid FornecedorModel fornecedorModel) {
		return fornecedorService.salvar(fornecedorModel);
	}
	
	@GetMapping("/{FornecedorId}")
    public ResponseEntity<FornecedorModel> buscarPorId(@PathVariable Long FornecedorId) {
    	return fornecedorRepository.findById(FornecedorId)
    			.map(ResponseEntity::ok)
    			.orElse(ResponseEntity.notFound().build());
    }
	
    @PutMapping
	public ResponseEntity<FornecedorModel> atualizar(@Valid @PathVariable Long FornecedorId, @RequestBody FornecedorModel fornecedor) {
		if (!fornecedorRepository.existsById(FornecedorId)) {
			return ResponseEntity.notFound().build();
		}
		fornecedor.setIdfornecedor(FornecedorId);
		fornecedor = fornecedorService.salvar(fornecedor);
		return ResponseEntity.ok(fornecedor);
	}
}
