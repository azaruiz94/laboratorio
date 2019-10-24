package com.fiuni.sd.dto.ubicacion.departamento;

import java.util.List;
import com.fiuni.sd.dto.base.BaseResult;

public class DepartamentoResult extends BaseResult<DepartamentoDTO> {
	private static final long serialVersionUID = 1L;

	public List<DepartamentoDTO> getDepartamentos() {
		return getList();
	}

	public void setDepartamentos(List<DepartamentoDTO> dtos) {
		super.setList(dtos);
	}
}