package com.fiuni.sd.domain.ubicacion.ciudad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fiuni.sd.domain.base.BaseDomain;
import com.fiuni.sd.domain.ubicacion.departamento.DepartamentoDomain;

@Entity
@Table(name = "ciudad")
public class CiudadDomain implements BaseDomain {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "nombre")
	private String _nombre;

	@ManyToOne
	private DepartamentoDomain _departamento;

	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public DepartamentoDomain getDepartamento() {
		return _departamento;
	}

	public void setDepartamento(DepartamentoDomain departamento) {
		_departamento = departamento;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	@Override
	public String toString() {
		return "CiudadDomain [_id=" + _id + ", _nombre=" + _nombre + ", _departamento=" + _departamento + "]";
	}

}