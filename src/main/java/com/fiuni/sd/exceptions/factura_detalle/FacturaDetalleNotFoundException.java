package com.fiuni.sd.exceptions.factura_detalle;

public class FacturaDetalleNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FacturaDetalleNotFoundException(Integer id) {
		super("No se pudo encontrar el detalle " + id);
	}
}