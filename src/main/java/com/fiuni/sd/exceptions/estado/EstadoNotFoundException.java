package com.fiuni.sd.exceptions.estado;

public class EstadoNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EstadoNotFoundException(Integer id) {
		super("No se pudo encontrar el tipo de estado " + id);
	}
}