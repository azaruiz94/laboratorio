package com.fiuni.sd.domain.centro_asistencial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fiuni.sd.domain.base.BaseDomain;

@Entity
@Table(name = "metrica")
public class CentroAsistencialDomain implements BaseDomain {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "nombre", nullable = false, unique = true)
	private String _nombre;
	
	@Column(name = "ciudad_id")
	private Integer _ciudadId;


	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}
	
	public Integer getCityId() {
		return _ciudadId;
	}

	public void setCityId(Integer ciudadId) {
		_ciudadId = ciudadId;
	}

	@Override
	public String toString() {
		return "MetricaDomain [_id=" + _id + ", _nombre=" + _nombre + "]";
	}

}