package com.fiuni.sd.dto.centro_asistencial;

import java.util.List;

import com.fiuni.sd.dto.base.BaseResult;


public class CentroAsistencialResult extends BaseResult<CentroAsistencialDTO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<CentroAsistencialDTO> getCentroAsistenciales(){
		return getList();
	}
	
	public void setCentroAsistenciales(List<CentroAsistencialDTO> dtos) {
		super.setList(dtos);
	}
	
}