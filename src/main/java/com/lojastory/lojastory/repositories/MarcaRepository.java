package com.lojastory.lojastory.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojastory.lojastory.entities.MarcaModel;

@Repository
public interface MarcaRepository extends JpaRepository<MarcaModel, Long> {

	Optional<MarcaModel> findBydescricaomarca(String descricao); 
}

