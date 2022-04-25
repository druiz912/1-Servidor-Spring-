package com.peliculeo.project.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.peliculeo.project.model.Peliculas;
import com.peliculeo.project.services.IPeliculasService;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@Controller
public class AltaPeliculaController {

	@Autowired(required= false)
	private IPeliculasService pelisService;

	@RequestMapping(value = "addPeliculas", method = RequestMethod.GET)
	public String addPeliculas(
			@RequestParam(name = "titulo", required = false) String titulo,
			@RequestParam(name = "sinopsis", required = false) String sinopsis, 
			@RequestParam(name = "fechaEstreno", required = false) String fechaEstreno,
			@RequestParam(name = "imagen", required = false) String imagen, 
			@RequestParam(name = "video", required = false) String video, Model model) 
	{
		Peliculas pelis = new Peliculas(titulo, sinopsis, fechaEstreno, imagen, video);
		pelisService.addPeliculas(pelis);
		return "/crearPelicula";

	}

}
