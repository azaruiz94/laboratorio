package com.fiuni.sd.dto.ubicacion.ciudad;

import java.util.List;
import com.fiuni.sd.dto.base.BaseResult;

public class CiudadResult extends BaseResult<CiudadDTO> {
	private static final long serialVersionUID = 1L;

	public List<CiudadDTO> getCiudades() {
		return getList();
	}

	public void setCiudades(List<CiudadDTO> dtos) {
		super.setList(dtos);
	}
}