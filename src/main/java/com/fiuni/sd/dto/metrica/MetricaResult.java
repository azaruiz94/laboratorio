package com.fiuni.sd.dto.metrica;

import java.util.List;

import com.fiuni.sd.dto.base.BaseResult;


public class MetricaResult extends BaseResult<MetricaDTO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<MetricaDTO> getMetricas(){
		return getList();
	}
	
	public void setMetricas(List<MetricaDTO> dtos) {
		super.setList(dtos);
	}
	
}