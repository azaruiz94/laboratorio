package com.fiuni.sd.dto.tipo_persona;



import com.fiuni.sd.dto.base.BaseDTO;


public class TipoPersonaDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String descripcion) {
		this._descripcion = descripcion;
	}

	private String _descripcion;
	
}
