package com.fiuni.sd.domain.estado;

import com.fiuni.sd.domain.base.BaseDomain;

public class EstadoDomain extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String descripcion) {
		this._descripcion = descripcion;
	}

	private String _descripcion;
}
