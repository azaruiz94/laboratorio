package com.fiuni.sd.dto.persona;

import com.fiuni.sd.dto.base.BaseDTO;

public class PersonaDTO extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Integer getCiudadId() {
		return _ciudadId;
	}
	
	public void setCiudadId(Integer ciudadId) {
		this._ciudadId = ciudadId;
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
	
	public String getEmail() {
		return _email;
	}
	
	public void setEmail(String email) {
		this._email = email;
	}
	
	public String getDireccion() {
		return _direccion;
	}
	
	public void setDireccion(String direccion) {
		this._direccion = direccion;
	}
	
	public String getTelefono() {
		return _telefono;
	}
	
	public void setTelefono(String telefono) {
		this._telefono = telefono;
	}
	
	public Integer getNumero_registro() {
		return _numero_registro;
	}
	
	public void setNumero_registro(Integer numero_registro) {
		this._numero_registro = numero_registro;
	}
	
	public Integer getSexoId() {
		return _sexoId;
	}
	
	public void setSexoId(Integer sexoId) {
		this._sexoId = sexoId;
	}
	
	public Integer getTipoPersonaId() {
		return _tipoPersonaId;
	}
	
	public void setTipoPersonaId(Integer tipoPersonaId) {
		this._tipoPersonaId = tipoPersonaId;
	}
	

	private Integer _tipoPersonaId;
	private Integer _sexoId;
	private Integer _ciudadId;
	private Integer _numero_registro;
	private String _nombre;
	private String _ruc_ci;
	private String _email;
	private String _telefono;
	private String _direccion;
}