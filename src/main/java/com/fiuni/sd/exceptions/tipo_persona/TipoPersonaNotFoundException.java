package com.fiuni.sd.exceptions.tipo_persona;

public class TipoPersonaNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TipoPersonaNotFoundException(Integer id) {
		super("No se pudo encontrar el tipo de persona " + id);
	}
}