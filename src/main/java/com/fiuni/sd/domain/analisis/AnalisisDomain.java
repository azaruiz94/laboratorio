package com.fiuni.sd.domain.analisis;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fiuni.sd.domain.base.BaseDomain;

@Entity
@Table(name = "analisis")
public class AnalisisDomain implements BaseDomain {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "nombre", nullable = false, unique = true)
	private String _nombre;
	@Column(name = "costo", nullable = false)
	private Double _costo;
	@Column(name = "valor_referencia_id", nullable = false)
	private Integer _valorReferenciaId;
	@Column(name = "tipo_analisis_id", nullable = false)
	private Integer _tipoAnalisisId;
	@Column(name = "sexo_id", nullable = false)
	private Integer _sexoId;


	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String costo) {
		_nombre = costo;
	}
	
	public Double getCosto() {
		return _costo;
	}

	public void setCosto(Double costo) {
		_costo = costo;
	}
	
	public Integer getValorReferenciaId() {
		return _valorReferenciaId;
	}

	public void setValorReferenciaId(Integer valorReferenciaId) {
		_valorReferenciaId = valorReferenciaId;
	}
	
	public Integer getTipoAnalisisId() {
		return _valorReferenciaId;
	}

	public void setTipoAnalisisId(Integer tipoAnalisisId) {
		_valorReferenciaId = tipoAnalisisId;
	}
	
	public Integer getSexoId() {
		return _sexoId;
	}

	public void setSexoId(Integer sexoId) {
		_sexoId = sexoId;
	}

	@Override
	public String toString() {
		return "AnalisisDomain [_id=" + _id + ", _nombre=" + _nombre + ", _valorReferenciaId=" + _valorReferenciaId + ", _tipoAnalisisId=" + _tipoAnalisisId + ", _sexoId=" + _sexoId + "]";
	}

}