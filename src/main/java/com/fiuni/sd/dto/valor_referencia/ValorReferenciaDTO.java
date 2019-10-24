package com.fiuni.sd.dto.valor_referencia;

import com.fiuni.sd.dto.base.BaseDTO;

public class ValorReferenciaDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	private Integer _metricaId;
	private String _min;
	private String _max;

	public Integer getMetricaId() {
		return _metricaId;
	}

	public void setMetricaId(Integer metricaId) {
		_metricaId = metricaId;
	}

	public String getMin() {
		return _min;
	}

	public void setMin(String min) {
		_min = min;
	}
	
	public String getMax() {
		return _max;
	}

	public void setMax(String max) {
		_min = max;
	}
}