package com.fiuni.sd.dto.persona;

import java.util.List;

import com.fiuni.sd.dto.base.BaseResult;

public class PersonaResult extends BaseResult<PersonaDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<PersonaDTO> getPersonas(){
		return getList();
	}
	
	public void setPersonas(List<PersonaDTO> dtos) {
		super.setList(dtos);
	}
}