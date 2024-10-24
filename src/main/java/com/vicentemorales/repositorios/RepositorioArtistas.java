package com.vicentemorales.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vicentemorales.modelos.Artistas;


@Repository
public interface RepositorioArtistas extends CrudRepository<Artistas, Long> {

	List<Artistas>findAll();
		
		Optional<Artistas> findById(Long id);
}
