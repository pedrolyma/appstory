package com.lojastory.lojastory.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lojastory.lojastory.entities.UserModel;
import com.lojastory.lojastory.exception.NegocioException;
import com.lojastory.lojastory.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public UserModel salvar(UserModel user) {
		
		  UserModel userExiste = userRepository.findByusername(user.getUsername());
		  if (userExiste != null && !userExiste.equals(user)) {
			  throw new NegocioException("User Ja Cadastrado na Base de Dados"); }

		return userRepository.save(user);
	} 

	public UserModel buscarPeloId(Long codigo) {
		Optional<UserModel> userSalvo = userRepository.findById(codigo);
		if (userSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return userSalvo.orElseThrow();
	}
}
