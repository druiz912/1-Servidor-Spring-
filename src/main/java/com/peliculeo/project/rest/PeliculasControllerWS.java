package com.peliculeo.project.rest;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.peliculeo.project.controllers.Response;
import com.peliculeo.project.exception.PeliculasNotFoundException;
import com.peliculeo.project.model.Peliculas;
import com.peliculeo.project.services.IPeliculasService;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
public class PeliculasControllerWS {
	
	@Autowired
	private IPeliculasService pelisService;
	
	  @PutMapping("/peliculas/{id}")
	    public ResponseEntity<Peliculas> modifyProduct
	    (@PathVariable int id, @RequestBody Peliculas newPeli) {
	        Peliculas pelis= pelisService.modifyPelis(id, newPeli);
	        return new ResponseEntity<>(pelis, HttpStatus.OK);
	    }
	
	  @PostMapping("/peliculas")
	    public ResponseEntity<Peliculas> addPeliculas
	    (@RequestBody Peliculas pelis) {
	        Peliculas addedPelicula= pelisService.addPeliculas(pelis);
	        return new ResponseEntity<>(addedPelicula, HttpStatus.OK);
	    }
	
	
	@GetMapping("/peliculas/{id}")
    public ResponseEntity<Peliculas> getPeliculas
    (@PathVariable int id) {
        Peliculas pelis = pelisService.findById(id)
                .orElseThrow(() -> new PeliculasNotFoundException(id));
 
        return new ResponseEntity<>(pelis, HttpStatus.OK);
    }
	
	  @DeleteMapping("/peliculas/{id}")
	    public ResponseEntity<Response> deletePelis
	    (@PathVariable int id) {
	        pelisService.deletePelicula(id);
	        return new ResponseEntity<Response>(HttpStatus.OK);
	    }
	  
	  /*@ExceptionHandler(PeliculasNotFoundException.class)
	    @ResponseBody
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    public ResponseEntity<Response> handleException(PeliculasNotFoundException pnfe) {
	        Response response = ResponseEntity.errorResonse(NOT_FOUND, pnfe.getMessage());
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	    }
	    */
	    

	@GetMapping(path = "/peliculas/json", produces = { MediaType.APPLICATION_JSON_VALUE })
	List<Peliculas> getAll() {
		return pelisService.findAll();
	}

	@GetMapping(path = "/peliculas/xml", produces = { MediaType.APPLICATION_XML_VALUE })
	List<Peliculas> getAllXML() {
		return pelisService.findAll();
	}
	
	
	
	

}
