package com.fiuni.sd.dto.estado;

import java.util.List;

import com.fiuni.sd.dto.base.BaseResult;


public class EstadoResult extends BaseResult<EstadoDTO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<EstadoDTO> getEstados(){
		return getList();
	}
	
	public void setEstados(List<EstadoDTO> dtos) {
		super.setList(dtos);
	}
	
}