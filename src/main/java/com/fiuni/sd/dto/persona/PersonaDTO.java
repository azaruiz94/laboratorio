package com.fiuni.sd.dto.persona;

import com.fiuni.sd.dto.base.BaseDTO;

public class PersonaDTO extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Integer getCiudadDTOId() {
		return _ciudadDTOId;
	}
	
	public void setCiudadDTOId(Integer ciudadDTOId) {
		this._ciudadDTOId = ciudadDTOId;
	}
	
	public String getNombre() {
		return _nombre;
	}
	
	public void setNombre(String nombre) {
		this._nombre = nombre;
	}
	
	public String getRuc_ci() {
		return _ruc_ci;
	}
	
	public void setRuc_ci(String ruc_ci) {
		this._ruc_ci = ruc_ci;
	}
	
	public Integer getNumero_registro() {
		return _numero_registro;
	}
	
	public void setNumero_registro(Integer numero_registro) {
		this._numero_registro = numero_registro;
	}
	
	public Integer getSexoDTOId() {
		return _sexoDTOId;
	}
	
	public void setSexoDTOId(Integer sexoDTOId) {
		this._sexoDTOId = sexoDTOId;
	}
	
	public Integer getTipoPersonaDTOId() {
		return _tipoPersonaDTOId;
	}
	
	public void setTipoPersonaDTOId(Integer tipoPersonaDTOId) {
		this._tipoPersonaDTOId = tipoPersonaDTOId;
	}
	

	private Integer _tipoPersonaDTOId;
	private Integer _sexoDTOId;
	private Integer _ciudadDTOId;
	private String _nombre;
	private String _ruc_ci;
	private Integer _numero_registro;
}