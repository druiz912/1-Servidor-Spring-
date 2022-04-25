package com.peliculeo.project.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peliculeo.project.model.Peliculas;

@Repository
public interface IPeliculasRepository extends JpaRepository<Peliculas, Integer> {
	
	List<Peliculas> findAll();

}
