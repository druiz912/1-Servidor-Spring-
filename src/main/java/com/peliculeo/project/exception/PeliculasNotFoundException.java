package com.peliculeo.project.exception;

public class PeliculasNotFoundException extends RuntimeException {
	 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PeliculasNotFoundException() {
        super();
    }
 
    public PeliculasNotFoundException(String message) {
        super(message);
    }
 
    public PeliculasNotFoundException(int id) {
        super("Movie not found: " + id);
    }
}
