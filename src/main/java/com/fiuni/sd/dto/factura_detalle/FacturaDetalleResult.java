package com.fiuni.sd.dto.factura_detalle;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.dto.base.BaseResult;

@XmlRootElement(name ="facturaDetalleResult")
public class FacturaDetalleResult extends BaseResult<FacturaDetalleDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	public List<FacturaDetalleDTO> getFacturaDetalle(){
		return getList();
	}
	
	public void setFacturaDetalle(List<FacturaDetalleDTO> dtos) {
		super.setList(dtos);
	}
}