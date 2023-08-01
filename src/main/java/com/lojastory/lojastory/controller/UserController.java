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

import com.lojastory.lojastory.entities.GrupoModel;
import com.lojastory.lojastory.entities.UserModel;
import com.lojastory.lojastory.repositories.UserRepository;
import com.lojastory.lojastory.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
    @GetMapping
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserModel criar(@RequestBody @Valid UserModel userModel) {
		return userService.salvar(userModel);
    }
	
    @PutMapping("/{GrupoId}")
	public ResponseEntity<UserModel> atualizar(@Valid @PathVariable Long UserId, @RequestBody UserModel user) {
		if (!userRepository.existsById(UserId)) {
			return ResponseEntity.notFound().build();
		}
		user.setIdusuario(UserId);
		user = userService.salvar(user);
		return ResponseEntity.ok(user);
	}
}
