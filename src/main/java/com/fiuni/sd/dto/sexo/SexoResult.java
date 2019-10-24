package com.fiuni.sd.dto.sexo;

import java.util.List;

import com.fiuni.sd.dto.base.BaseResult;

public class SexoResult extends BaseResult<SexoDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<SexoDTO> getSexos(){
		return getList();
	}
	
	public void setSexos(List<SexoDTO> dtos) {
		super.setList(dtos);
	}
}