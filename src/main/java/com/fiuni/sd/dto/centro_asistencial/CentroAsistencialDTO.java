package com.fiuni.sd.dto.centro_asistencial;

import com.fiuni.sd.dto.base.BaseDTO;

public class CentroAsistencialDTO extends BaseDTO {

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
	
	public Integer getCiudad() {
		return _ciudad;
	}

	public void setCiudad(Integer ciudad) {
		_ciudad = ciudad;
	}

	private String _nombre;
	private Integer _ciudad;
	
}