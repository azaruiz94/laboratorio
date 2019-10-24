package com.fiuni.sd.dto.ubicacion.departamento;

import com.fiuni.sd.dto.base.BaseDTO;

public class DepartamentoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	private Integer _paisId;
	private String _nombre;

	public Integer getPaisId() {
		return _paisId;
	}

	public void setPaisId(Integer paisId) {
		_paisId = paisId;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}
}