package com.fiuni.sd.dto.factura;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.dto.base.BaseResult;

@XmlRootElement(name="facturaResult")
public class FacturaResult extends BaseResult<FacturaDTO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	public List<FacturaDTO> getFacturas(){
		return getList();
	}
	
	public void setFacturas(List<FacturaDTO> dtos) {
		super.setList(dtos);
	}
	
}