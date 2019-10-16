package com.fiuni.sd.domain.valor_referencia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fiuni.sd.domain.base.BaseDomain;

@Entity
@Table(name = "valor_referencia")
public class ValorReferenciaDomain implements BaseDomain {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "nombre", nullable = false, unique = true)
	private String _nombre;


	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

}