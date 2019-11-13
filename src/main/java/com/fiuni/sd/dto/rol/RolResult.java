package com.fiuni.sd.dto.rol;

import com.fiuni.sd.dto.base.BaseResult;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import java.util.List;

@XmlRootElement(name = "rolResult")
public class RolResult extends BaseResult<RolDTO>{

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<RolDTO> getRoles(){
		return getList();
	}

	public void setRoles(List<RolDTO> dtos) {
		super.setList(dtos);
	}
}