package com.fiuni.sd.dto.usuario;

import java.util.List;

import com.fiuni.sd.dto.base.BaseResult;


public class UsuarioResult extends BaseResult<UsuarioDTO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<UsuarioDTO> getUsuarios(){
		return getList();
	}
	
	public void setUsuarios(List<UsuarioDTO> dtos) {
		super.setList(dtos);
	}
	
}