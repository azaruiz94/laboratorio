package com.fiuni.sd.dto.ubicacion.pais;

import java.util.List;
import com.fiuni.sd.dto.base.BaseResult;

public class PaisResult extends BaseResult<PaisDTO> {
	private static final long serialVersionUID = 1L;

	public List<PaisDTO> getPaises() {
		return getList();
	}

	public void setPaises(List<PaisDTO> dtos) {
		super.setList(dtos);
	}
}