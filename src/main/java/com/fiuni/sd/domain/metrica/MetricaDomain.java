package com.fiuni.sd.domain.metrica;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fiuni.sd.domain.base.BaseDomain;

@Entity
@Table(name = "metrica")
public class MetricaDomain implements BaseDomain {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "unidad_medida", nullable = false, unique = true)
	private String _unidadMedida;


	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public String getUnidadMedida() {
		return _unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		_unidadMedida = unidadMedida;
	}

	@Override
	public String toString() {
		return "MetricaDomain [_id=" + _id + ", _nombre=" + _unidadMedida + "]";
	}

}