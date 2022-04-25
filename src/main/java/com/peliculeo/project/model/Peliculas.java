package com.peliculeo.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "peliculas")
public class Peliculas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int identificador;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "sinopsis")
	private String sinopsis;
	@Column(name = "fechaestreno")
	public String fechaEstreno;
	@Column(name = "imagen")
	private String imagen;
	@Column(name = "video")
	private String video;

	// Constructor vacío
	public Peliculas() {
		super();
	}

	// Constructor completo
	public Peliculas(int identificador, String titulo, String sinopsis, String fechaEstreno, String imagen,
			String video) {
		super();
		this.identificador = identificador;
		this.titulo = titulo;
		this.sinopsis = sinopsis;
		this.fechaEstreno = fechaEstreno;
		this.imagen = imagen;
		this.video = video;
	}

	// Constructor sin id
	public Peliculas(String titulo, String sinopsis, String fechaEstreno, String imagen, String video) {
		super();
		this.titulo = titulo;
		this.sinopsis = sinopsis;
		this.fechaEstreno = fechaEstreno;
		this.imagen = imagen;
		this.video = video;
	}

	// GETTERS & SETTERS

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(String fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
}