package com.peliculeo.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.peliculeo.project.model.Peliculas;
import com.peliculeo.project.services.IPeliculasService;

@Controller
public class PeliculasController {

	@Autowired
	private IPeliculasService peliculasService;

	@RequestMapping(value = "/crearPelicula") 
	public ModelAndView crearPelicula (   
			@RequestParam( name = "titulo", required = false) String titulo,
			@RequestParam( name = "sinopsis", required = false) String sinopsis,
			@RequestParam( name = "fechaEstreno", required = false) String fechaEstreno,
			@RequestParam( name = "imagen", required = false) String imagen,
			@RequestParam( name = "video", required = false) String video, Model model) {
		if (titulo != null) {
			
			Peliculas pelis = new Peliculas (titulo, sinopsis, fechaEstreno, imagen, video);
			peliculasService.addPeliculas(pelis);
		}
		List<Peliculas> pelis = peliculasService.findAll();
		ModelAndView mav = new ModelAndView(); // Ahora ModelAndView es mav
		// Le damos nombre al ModelAndView
		mav.setViewName("crearPelicula");
		// Y añadimos el objeto con sus dos parametros
		mav.addObject("Peliculas", pelis);
		return mav;

	}

}
