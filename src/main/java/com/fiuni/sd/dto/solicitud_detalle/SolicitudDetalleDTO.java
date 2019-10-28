package com.fiuni.sd.dto.solicitud_detalle;

import com.fiuni.sd.dto.base.BaseDTO;

public class SolicitudDetalleDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer _solicitudId;
	private Integer _analisisId;
	private String _valorObtenido;
	private Integer _bioquimicoId;
	
	public Integer getSolicitudId() {
		return _solicitudId;
	}

	public void setSolicitudId(Integer solicitud) {
		_solicitudId = solicitud;
	}
	
	public Integer getAnalisisId() {
		return _analisisId;
	}
	
	public void setAnalisisId(Integer analisis) {
		_analisisId= analisis;
	}
	
	public String getValorObtenido() {
		return _valorObtenido;
	}
	
	public void setValorObtenido(String valorObtenido) {
		_valorObtenido= valorObtenido;
	}
	
	public Integer getBioquimicoId() {
		return _bioquimicoId;
	}
	
	public void setBioquimicoId(Integer bioquimico) {
		_bioquimicoId= bioquimico;
	}

}