package com.fiuni.sd.dto.persona;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import com.fiuni.sd.dto.base.BaseResult;

@XmlRootElement(name ="personaResult")
public class PersonaResult extends BaseResult<PersonaDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	public List<PersonaDTO> getPersonas(){
		return getList();
	}
	
	public void setPersonas(List<PersonaDTO> dtos) {
		super.setList(dtos);
	}
}