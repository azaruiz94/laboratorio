package com.fiuni.sd.dto.iva;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.dto.base.BaseDTO;

@XmlRootElement(name="Iva")
public class IvaDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	public Integer getValor() {
		return _valor;
	}
	
	public void setValor(Integer valor) {
		this._valor = valor;
	}
	
	private Integer _valor;
	
}