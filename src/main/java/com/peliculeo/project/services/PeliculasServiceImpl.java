package com.peliculeo.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peliculeo.project.exception.PeliculasNotFoundException;
import com.peliculeo.project.model.Peliculas;
import com.peliculeo.project.repository.IPeliculasRepository;

@Service
public class PeliculasServiceImpl implements IPeliculasService {
	
	@Autowired
	private IPeliculasRepository pelisRepo;
	
	
	@Override
	public Peliculas addPeliculas(Peliculas pelis) {
		return pelisRepo.save(pelis);
	}

	@Override
	public List<Peliculas> findAll() {
		return pelisRepo.findAll();
	}
	
	 
	    @Override
	    public Optional<Peliculas> findById(int id) {
	        return pelisRepo.findById(id);
	    }

	    @Override
	    public Peliculas modifyPelis(int id, Peliculas newPeli) {
	        Peliculas pelis = pelisRepo.findById(id)
	                .orElseThrow(() -> new PeliculasNotFoundException(id));
	        newPeli.setIdentificador(pelis.getIdentificador());
	        return pelisRepo.save(newPeli);
	    }

	    @Override
	    public void deletePelicula(int id) {
	        pelisRepo.findById(id)
	                .orElseThrow(() -> new PeliculasNotFoundException(id));
	        pelisRepo.deleteById(id);
	    }

}
