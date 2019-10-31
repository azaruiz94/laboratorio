package com.fiuni.sd.exceptions.sexo;

public class SexoNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SexoNotFoundException(Integer id) {
		super("No se pudo encontrar el sexo " + id);
	}
}