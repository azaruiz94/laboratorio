package com.fiuni.sd.domain.iva;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fiuni.sd.domain.base.BaseDomain;

@Entity
@Table(name="iva")
public class IvaDomain implements BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Integer getValor() {
		return _valor;
	}

	public void setValor(int valor) {
		this._valor = valor;
	}
	
	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer _id) {
		this._id = _id;
	}

	@Column(name="valor")
	private Integer _valor;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
}