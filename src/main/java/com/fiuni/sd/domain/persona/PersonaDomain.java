package com.fiuni.sd.domain.persona;

import java.util.List;

import com.fiuni.sd.domain.base.BaseDomain;
import com.fiuni.sd.domain.ciudad.CiudadDomain;
import com.fiuni.sd.domain.sexo.SexoDomain;
import com.fiuni.sd.domain.tipo_persona.TipoPersonaDomain;

public class PersonaDomain extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public CiudadDomain getCiudad() {
		return _ciudad;
	}
	public void setCiudad(CiudadDomain ciudad) {
		this._ciudad = ciudad;
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
	public int getNumero_registro() {
		return _numero_registro;
	}
	public void setNumero_registro(int numero_registro) {
		this._numero_registro = numero_registro;
	}
	public SexoDomain getSexo() {
		return _sexo;
	}
	public void setSexo(SexoDomain sexo) {
		this._sexo = sexo;
	}
	public List<TipoPersonaDomain> getTipoPersona() {
		return _tipoPersona;
	}
	public void setTipoPersona(List<TipoPersonaDomain> tipoPersona) {
		this._tipoPersona = tipoPersona;
	}

	private List<TipoPersonaDomain> _tipoPersona;
	private SexoDomain _sexo;
	private CiudadDomain _ciudad;
	private String _nombre;
	private String _ruc_ci;
	private String _email;
	private String _direccion;
	private String _telefono;
	private int _numero_registro;
}