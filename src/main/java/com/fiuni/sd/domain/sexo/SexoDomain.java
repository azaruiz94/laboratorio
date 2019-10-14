package com.fiuni.sd.domain.sexo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fiuni.sd.domain.base.BaseDomain;

@Entity
@Table(name="sexo")
public class SexoDomain implements BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String descripcion) {
		this._descripcion = descripcion;
	}

	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer _id) {
		this._id = _id;
	}
	
	@Column(name="descripcion")
	private String _descripcion;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

}