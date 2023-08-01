package com.lojastory.lojastory.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojastory.lojastory.entities.SecaoModel;

@Repository
public interface SecaoRepository extends JpaRepository<SecaoModel, Long> {

	Optional<SecaoModel> findBydescricaosecao(String descricao); 
}
