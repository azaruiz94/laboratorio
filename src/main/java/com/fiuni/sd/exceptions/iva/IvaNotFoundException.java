package com.fiuni.sd.exceptions.iva;

public class IvaNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IvaNotFoundException(Integer id) {
		super("No se pudo encontrar el iva " + id);
	}
}