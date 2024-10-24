package com.vicentemorales.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicentemorales.modelos.Artistas;
import com.vicentemorales.modelos.Cancion;
import com.vicentemorales.repositorios.RepositorioArtistas;
import com.vicentemorales.repositorios.RepositorioCanciones;

@Service
public class ServicioArtistas {

	@Autowired
	RepositorioArtistas repositorioArtistas;
	
	public List<Artistas> obtenerTodasLosArtistas(){
		return repositorioArtistas.findAll();
	}
	
	public Artistas obtenerArtistaPorId(Long idArtistas) {
		return this.repositorioArtistas.findById(idArtistas).orElse(null);
	}
	
	public Artistas agregarArtista(Artistas artistaNuevo) {
   		return this.repositorioArtistas.save(artistaNuevo);
	}
}
