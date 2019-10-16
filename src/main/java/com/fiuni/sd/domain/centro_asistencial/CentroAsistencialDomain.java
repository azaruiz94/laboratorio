package com.fiuni.sd.domain.centro_asistencial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fiuni.sd.domain.base.BaseDomain;
import com.fiuni.sd.domain.ubicacion.ciudad.CiudadDomain;

@Entity
@Table(name = "centro_asistencial")
public class CentroAsistencialDomain implements BaseDomain {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "nombre", nullable = false, unique = true)
	private String _nombre;
	
	@Column(name = "ciudad_id")
	private CiudadDomain _ciudad;


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
	
	public CiudadDomain getCiudad() {
		return _ciudad;
	}

	public void setCiudad(CiudadDomain ciudad) {
		_ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "MetricaDomain [_id=" + _id + ", _nombre=" + _nombre + "]";
	}

}