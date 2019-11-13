package com.fiuni.sd.dto.rol;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.fiuni.sd.dto.base.BaseDTO;

@XmlRootElement(name = "usuario")
public class RolDTO extends BaseDTO{

	private static final long serialVersionUID = -9097944624604913579L;
	private String _rol;
	
	@XmlElement
	public String getRol() {
		return _rol;
	}

	public void setRol(String _authority) {
		this._rol = _authority;
	}	
}