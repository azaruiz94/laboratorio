package com.fiuni.sd.service.solicitud_detalle;

import com.fiuni.sd.dto.solicitud_detalle.SolicitudDetalleDTO;
import com.fiuni.sd.dto.solicitud_detalle.SolicitudDetalleResult;
import com.fiuni.sd.service.base.IBaseService;

public interface ISolicitudDetalleService extends IBaseService<SolicitudDetalleDTO, SolicitudDetalleResult> {

	public SolicitudDetalleResult find(String textToFind);
}
