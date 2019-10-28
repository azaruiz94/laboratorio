package com.fiuni.sd.dto.solicitud;

import java.util.List;
import com.fiuni.sd.dto.base.BaseResult;

public class SolicitudResult extends BaseResult<SolicitudDTO> {
	private static final long serialVersionUID = 1L;

	public List<SolicitudDTO> getSolicitudes() {
		return getList();
	}

	public void setSolicitudes(List<SolicitudDTO> dtos) {
		super.setList(dtos);
	}
}