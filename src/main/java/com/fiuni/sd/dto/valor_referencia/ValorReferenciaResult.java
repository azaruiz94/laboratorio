package com.fiuni.sd.dto.valor_referencia;

import java.util.List;
import com.fiuni.sd.dto.base.BaseResult;

public class ValorReferenciaResult extends BaseResult<ValorReferenciaDTO> {
	private static final long serialVersionUID = 1L;

	public List<ValorReferenciaDTO> getValorReferencia() {
		return getList();
	}

	public void setValorReferencia(List<ValorReferenciaDTO> dtos) {
		super.setList(dtos);
	}
}