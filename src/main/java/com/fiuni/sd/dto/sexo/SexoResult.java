package com.fiuni.sd.dto.sexo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import com.fiuni.sd.dto.base.BaseResult;

@XmlRootElement(name ="sexoResult")
public class SexoResult extends BaseResult<SexoDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	public List<SexoDTO> getSexos(){
		return getList();
	}
	
	public void setSexos(List<SexoDTO> dtos) {
		super.setList(dtos);
	}
}