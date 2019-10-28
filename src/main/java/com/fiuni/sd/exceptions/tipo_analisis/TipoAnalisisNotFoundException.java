package com.fiuni.sd.exceptions.tipo_analisis;

public class TipoAnalisisNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TipoAnalisisNotFoundException(Integer id) {
		super("No se pudo encontrar el tipo de analisis " + id);
	}
}