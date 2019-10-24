package com.fiuni.sd.dto.analisis;

import com.fiuni.sd.dto.base.BaseDTO;

public class AnalisisDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String _nombre;
	private Double _costo;
	private Integer _valorReferencia;
	private Integer _tipoAnalisis;
	private Integer _sexo;

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String costo) {
		_nombre = costo;
	}
	
	public Double getCosto() {
		return _costo;
	}

	public void setCosto(Double costo) {
		_costo = costo;
	}
	
	public Integer getValorReferencia() {
		return _valorReferencia;
	}

	public void setValorReferencia(Integer valorReferencia) {
		_valorReferencia = valorReferencia;
	}
	
	public Integer getTipoAnalisisId() {
		return _tipoAnalisis;
	}

	public void setTipoAnalisisId(Integer tipoAnalisis) {
		_tipoAnalisis = tipoAnalisis;
	}
	
	public Integer getSexoId() {
		return _sexo;
	}

	public void setSexoId(Integer sexo) {
		_sexo = sexo;
	}
	
}