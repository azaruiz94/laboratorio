package com.fiuni.sd.dto.iva;

import com.fiuni.sd.dto.base.BaseDTO;

public class IvaDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public Integer getValor() {
		return _valor;
	}
	
	public void setValor(Integer valor) {
		this._valor = valor;
	}
	
	private Integer _valor;
	
}