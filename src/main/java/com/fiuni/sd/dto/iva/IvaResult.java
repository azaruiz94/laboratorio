package com.fiuni.sd.dto.iva;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import com.fiuni.sd.dto.base.BaseResult;

@XmlRootElement(name ="ivaResult")
public class IvaResult extends BaseResult<IvaDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	public List<IvaDTO> getIvas(){
		return getList();
	}
	
	public void setIvas(List<IvaDTO> dtos) {
		super.setList(dtos);
	}
}