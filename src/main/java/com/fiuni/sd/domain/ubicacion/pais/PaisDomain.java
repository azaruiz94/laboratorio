package com.fiuni.sd.domain.ubicacion.pais;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fiuni.sd.domain.base.BaseDomain;
import com.fiuni.sd.domain.ubicacion.departamento.DepartamentoDomain;

@Entity
@Table(name = "pais")
public class PaisDomain implements BaseDomain {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "nombre", nullable = false, unique = true)
	private String _nombre;

	@OneToMany(mappedBy = "_pais")
	private Set<DepartamentoDomain> _departamentos = new HashSet<>();

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

	public Set<DepartamentoDomain> getDepartamentos() {
		return _departamentos;
	}

	public void setDepartamentos(Set<DepartamentoDomain> departamentos) {
		this._departamentos = departamentos;
	}

	@Override
	public String toString() {
		return "PaisDomain [_id=" + _id + ", _nombre=" + _nombre + ", _departamentos=" + _departamentos + "]";
	}
}