package com.fiuni.sd.dto.tipo_persona;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import com.fiuni.sd.dto.base.BaseResult;

@XmlRootElement(name ="tipoPersonaResult")
public class TipoPersonaResult extends BaseResult<TipoPersonaDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	public List<TipoPersonaDTO> getTipoPersonas(){
		return getList();
	}
	
	public void setTipoPersonas(List<TipoPersonaDTO> dtos) {
		super.setList(dtos);
	}
}