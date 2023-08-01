package com.lojastory.lojastory.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojastory.lojastory.entities.AgendaModel;

@Repository
public interface AgendaRepository extends JpaRepository<AgendaModel, Long> {

	Optional<AgendaModel> findBynomeagenda(String nome); 
}
