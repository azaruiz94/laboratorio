package com.fiuni.sd.domain.ubicacion.departamento;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fiuni.sd.domain.base.BaseDomain;
import com.fiuni.sd.domain.ubicacion.ciudad.CiudadDomain;
import com.fiuni.sd.domain.ubicacion.pais.PaisDomain;

@Entity
@Table(name = "departamento")
public class DepartamentoDomain implements BaseDomain {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "nombre")
	private String _nombre;

	@ManyToOne
	private PaisDomain _pais;
	
	@OneToMany(mappedBy="_departamento")
	private Set<CiudadDomain>_ciudades= new HashSet<>();

	
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
	
	public PaisDomain getPais() {
		return _pais;
	}

	public void setPais(PaisDomain pais) {
		_pais = pais;
	}

	public Set<CiudadDomain> getCiudades() {
		return _ciudades;
	}

	public void setCiudades(Set<CiudadDomain> ciudades) {
		_ciudades = ciudades;
	}

	@Override
	public String toString() {
		return "DepartamentoDomain [_id=" + _id + ", _nombre=" + _nombre + ", _pais=" + _pais+ ", _ciudades=" + _ciudades + "]";
	}

}
