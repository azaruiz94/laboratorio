package com.fiuni.sd.exceptions.factura;

public class FacturaNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FacturaNotFoundException(Integer id) {
		super("No se pudo encontrar la factura " + id);
	}
}