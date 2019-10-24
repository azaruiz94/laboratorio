package com.fiuni.sd.dto.tipo_analisis;

import java.util.List;

import com.fiuni.sd.dto.base.BaseResult;


public class TipoAnalisisResult extends BaseResult<TipoAnalisisDTO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<TipoAnalisisDTO> getTiposAnalisis(){
		return getList();
	}
	
	public void setTiposAnalisis(List<TipoAnalisisDTO> dtos) {
		super.setList(dtos);
	}
	
}