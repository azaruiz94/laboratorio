package com.fiuni.sd.service.solicitud;

import com.fiuni.sd.dto.solicitud.SolicitudDTO;
import com.fiuni.sd.dto.solicitud.SolicitudResult;
import com.fiuni.sd.service.base.IBaseService;

public interface ISolicitudService extends IBaseService<SolicitudDTO, SolicitudResult> {

	public SolicitudResult find(String textToFind);
}