package com.fiuni.sd.exceptions.persona;

public class PersonaNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonaNotFoundException(Integer id) {
		super("No se pudo encontrar la persona " + id);
	}
}