package com.peliculeo.project.services;

import java.util.List;
import java.util.Optional;

import com.peliculeo.project.model.Peliculas;

public interface IPeliculasService {
	
	  	//Modificar películas
	    Peliculas modifyPelis(int id, Peliculas newPeli);
		//Añadir película
		public Peliculas addPeliculas(Peliculas pelis);
		//Lista de peliculas
		public List<Peliculas> findAll();
		//Buscar pelicula por ID
		Optional<Peliculas> findById(int id);
		//Borrar película
		void deletePelicula(int id);
}