package com.fiuni.sd.dto.tipo_persona;

import java.util.List;

import com.fiuni.sd.dto.base.BaseResult;


public class TipoPersonaResult extends BaseResult<TipoPersonaDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<TipoPersonaDTO> getTipoPersonas(){
		return getList();
	}
	
	public void setTipoPersonas(List<TipoPersonaDTO> dtos) {
		super.setList(dtos);
	}
	
}