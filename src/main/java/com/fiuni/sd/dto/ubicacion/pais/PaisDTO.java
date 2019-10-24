package com.fiuni.sd.dto.ubicacion.pais;

import com.fiuni.sd.dto.base.BaseDTO;

public class PaisDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	private String _nombre;

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}
}