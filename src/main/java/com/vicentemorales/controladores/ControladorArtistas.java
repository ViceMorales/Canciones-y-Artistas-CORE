package com.vicentemorales.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.vicentemorales.modelos.Artistas;
import com.vicentemorales.modelos.Cancion;
import com.vicentemorales.servicios.ServicioArtistas;
import com.vicentemorales.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorArtistas {

	@Autowired
	ServicioArtistas servicioArtistas;
	
	@GetMapping("/artistas")
	public String desplegarArtistas(Model modelo){
		List<Artistas> artistas = servicioArtistas.obtenerTodasLosArtistas();
		modelo.addAttribute("artistas", artistas);
		return "artistas.jsp";
	}
	
	@GetMapping("/artistas/detalle/{id}")
	public String desplegarDetalleArtistas(Model modelo, @PathVariable Long id){
		Artistas artistas = servicioArtistas.obtenerArtistaPorId(id);
		modelo.addAttribute("artistas", artistas);
		return "detalleArtista.jsp";
		
	}
	@GetMapping("/artistas/formulario/agregar")
	public String formularioAgregarArtistas(@ModelAttribute Artistas artistas) {
		return "agregarArtista.jsp";
	}
	
	@PostMapping("/artistas/procesa/agregar")
	public String procesarAgregarArtistas(@Valid @ModelAttribute Artistas artistas,
										BindingResult validaciones){
		if(validaciones.hasErrors()) {
			return "agregarArtista.jsp";
		}
		this.servicioArtistas.agregarArtista(artistas);
		return "redirect:/artistas";
	}
}
