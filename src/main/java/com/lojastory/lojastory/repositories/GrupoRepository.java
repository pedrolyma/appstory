package com.lojastory.lojastory.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojastory.lojastory.entities.GrupoModel;

@Repository
public interface GrupoRepository extends JpaRepository<GrupoModel, Long> {

	GrupoModel findBydescricaogrupo(String descricao); 
}
