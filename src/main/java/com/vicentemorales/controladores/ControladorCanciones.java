package com.vicentemorales.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vicentemorales.modelos.Artistas;
import com.vicentemorales.modelos.Cancion;
import com.vicentemorales.servicios.ServicioArtistas;
import com.vicentemorales.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {
	@Autowired
	ServicioCanciones servicio;
	@Autowired
	ServicioArtistas servicioArtistas;
	
	@GetMapping("/canciones")
	public String desplegarCanciones(Model modelo){
		List<Cancion> canciones = servicio.obtenerTodasLasCanciones();
		List<Artistas> artistas = servicioArtistas.obtenerTodasLosArtistas();
		modelo.addAttribute("canciones", canciones);
		modelo.addAttribute("artistas", artistas);
		return "canciones.jsp";
	}
	
	@GetMapping("/canciones/detalle/{id}")
	public String desplegarDetalleCancion(Model modelo, @PathVariable Long id){
		Cancion cancion = servicio.obtenerCancionPorId(id);
		modelo.addAttribute("cancion", cancion);
		return "detalleCancion.jsp";
		
	}
	@GetMapping("/canciones/formulario/agregar")
	public String formularioAgregarCancion(@ModelAttribute Cancion cancion,
										Model model){
		List<Artistas> artistas = servicioArtistas.obtenerTodasLosArtistas();
		model.addAttribute("artistas", artistas);
		return "agregarCancion.jsp";
	}
	
	@PostMapping("/canciones/formulario/agregar")
	public String procesarAgregarCancion(@Valid @ModelAttribute Cancion cancion,
										BindingResult validaciones,
										@RequestParam Long idArtistas){
		System.out.println("id" + idArtistas);
		if(validaciones.hasErrors()) {
			return "agregarCancion.jsp";
		}
		Artistas artistas = servicioArtistas.obtenerArtistaPorId(idArtistas);
		cancion.setArtistas(artistas);
		this.servicio.agregarCancion(cancion);
		return "redirect:/canciones";
	}
	
	@GetMapping("/canciones/formulario/editar/{idCancion}")
	public String formularioEditarCancion(@ModelAttribute("cancion") Cancion cancion,
											@PathVariable Long idCancion,
											Model model){
		Cancion cancionEditar = servicio.obtenerCancionPorId(idCancion);
		model.addAttribute("cancion", cancionEditar);
		return "editarCancion.jsp";
		
	    }
	
 	@PutMapping("/canciones/procesa/editar/{idCancion}")
   	public String procesarEditarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
   										BindingResult validaciones,
                                         @PathVariable("idCancion") Long idCancion) {
 		
   		if(validaciones.hasErrors()) {
   			return "editarCancion.jsp";
   		}
   		
   		cancion.setId(idCancion);
		this.servicio.actualizarCancion(cancion);
     	  	return "redirect:/canciones";
   	}

 	@DeleteMapping("/canciones/eliminar/{idCancion}")
   	public String procesarEliminarCancion(@PathVariable("idCancion") 
   								Long idUsuario) {
		this.servicio.eliminarCancion(idUsuario);

     	  	return "redirect:/canciones";
   	}
		
}
