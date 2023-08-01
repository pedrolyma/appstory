package com.lojastory.lojastory.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojastory.lojastory.entities.FornecedorModel;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorModel, Long> {

	Optional<FornecedorModel> findByrazaosocial(String descricao);
}
