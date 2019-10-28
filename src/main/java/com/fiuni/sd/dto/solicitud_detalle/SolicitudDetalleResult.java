package com.fiuni.sd.dto.solicitud_detalle;

import java.util.List;
import com.fiuni.sd.dto.base.BaseResult;

public class SolicitudDetalleResult extends BaseResult<SolicitudDetalleDTO> {
	private static final long serialVersionUID = 1L;

	public List<SolicitudDetalleDTO> getSolicitudes() {
		return getList();
	}

	public void setSolicitudes(List<SolicitudDetalleDTO> dtos) {
		super.setList(dtos);
	}
}