package com.fiuni.sd.service.pais;

import com.fiuni.sd.dto.ubicacion.pais.PaisDTO;
import com.fiuni.sd.dto.ubicacion.pais.PaisResult;
import com.fiuni.sd.service.base.IBaseService;

public interface IPaisService extends IBaseService<PaisDTO, PaisResult> {

	public PaisResult find(String textToFind);
}