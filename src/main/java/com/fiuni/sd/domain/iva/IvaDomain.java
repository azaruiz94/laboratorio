package com.fiuni.sd.domain.iva;

import com.fiuni.sd.domain.base.BaseDomain;

public class IvaDomain extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public int getValor() {
		return _valor;
	}

	public void setValor(int valor) {
		this._valor = valor;
	}

	private int _valor;
}