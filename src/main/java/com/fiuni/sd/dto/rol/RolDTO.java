package com.fiuni.sd.dto.rol;

import java.util.Set;

import com.fiuni.sd.dto.base.BaseDTO;

public class RolDTO extends BaseDTO{

	private static final long serialVersionUID = -9097944624604913579L;
	
	private String _rol;
	private Set<Integer> _usuarioIds;
	
	public String getRol() {
		return _rol;
	}

	public void setRol(String _authority) {
		this._rol = _authority;
	}

	public Set<Integer> getUsuarioIds() {
		return _usuarioIds;
	}

	public void setUsuarioIds(Set<Integer> usuarioIds) {
		_usuarioIds = usuarioIds;
	}	
}