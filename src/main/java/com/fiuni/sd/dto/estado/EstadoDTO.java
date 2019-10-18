package com.fiuni.sd.dto.estado;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.dto.base.BaseDTO;

@XmlRootElement(name="estado")
public class EstadoDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String descripcion) {
		this._descripcion = descripcion;
	}

	private String _descripcion;
	
}
