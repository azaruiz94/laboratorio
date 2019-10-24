package com.fiuni.sd.dto.metrica;

import com.fiuni.sd.dto.base.BaseDTO;


public class MetricaDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getUnidadMedida() {
		return _unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		_unidadMedida = unidadMedida;
	}

	private String _unidadMedida;
	
}