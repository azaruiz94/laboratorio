package com.fiuni.sd.dto.tipo_analisis;

import com.fiuni.sd.dto.base.BaseDTO;


public class TipoAnalisisDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		this._nombre = nombre;
	}

	private String _nombre;
	
}