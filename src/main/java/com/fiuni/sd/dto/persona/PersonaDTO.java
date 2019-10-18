package com.fiuni.sd.dto.persona;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.dto.base.BaseDTO;

@XmlRootElement(name="persona")
public class PersonaDTO extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	public Integer getCiudadDTOId() {
		return _ciudadDTOId;
	}
	
	public void setCiudadDTOId(Integer ciudadDTOId) {
		this._ciudadDTOId = ciudadDTOId;
	}
	
	@XmlElement
	public String getNombre() {
		return _nombre;
	}
	
	public void setNombre(String nombre) {
		this._nombre = nombre;
	}
	
	@XmlElement
	public String getRuc_ci() {
		return _ruc_ci;
	}
	
	public void setRuc_ci(String ruc_ci) {
		this._ruc_ci = ruc_ci;
	}
	
	@XmlElement
	public Integer getNumero_registro() {
		return _numero_registro;
	}
	
	public void setNumero_registro(Integer numero_registro) {
		this._numero_registro = numero_registro;
	}
	
	@XmlElement
	public Integer getSexoDTOId() {
		return _sexoDTOId;
	}
	
	public void setSexoDTOId(Integer sexoDTOId) {
		this._sexoDTOId = sexoDTOId;
	}
	
	@XmlElement
	public List<Integer> getTipoPersonaDTOId() {
		return _tipoPersonaDTOId;
	}
	
	public void setTipoPersonaDTOId(List<Integer> tipoPersonaDTOId) {
		this._tipoPersonaDTOId = tipoPersonaDTOId;
	}
	
	@XmlElement
	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer _id) {
		this._id = _id;
	}

	private List<Integer> _tipoPersonaDTOId;
	private Integer _sexoDTOId;
	private Integer _ciudadDTOId;
	private String _nombre;
	private String _ruc_ci;
	private Integer _numero_registro;
	private Integer _id;
}