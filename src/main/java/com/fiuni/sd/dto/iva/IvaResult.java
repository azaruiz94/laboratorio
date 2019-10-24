package com.fiuni.sd.dto.iva;

import java.util.List;

import com.fiuni.sd.dto.base.BaseResult;

public class IvaResult extends BaseResult<IvaDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<IvaDTO> getIvas(){
		return getList();
	}
	
	public void setIvas(List<IvaDTO> dtos) {
		super.setList(dtos);
	}
}