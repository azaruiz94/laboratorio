package com.fiuni.sd.dto.analisis;

import java.util.List;

import com.fiuni.sd.dto.base.BaseResult;


public class AnalisisResult extends BaseResult<AnalisisDTO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<AnalisisDTO> getListaAnalisis(){
		return getList();
	}
	
	public void setListaAnalisis(List<AnalisisDTO> dtos) {
		super.setList(dtos);
	}
	
}