package com.fiuni.sd.dto.ubicacion.ciudad;

import com.fiuni.sd.dto.base.BaseDTO;

public class CiudadDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	private Integer _paisId;
	private Integer _departamentoId;
	private String _nombre;

	public Integer getPaisId() {
		return _paisId;
	}

	public void setPaisId(Integer paisId) {
		_paisId = paisId;
	}

	public Integer getDepartamentoId() {
		return _departamentoId;
	}

	public void setDepartamentoId(Integer departamentoId) {
		_departamentoId = departamentoId;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}
}