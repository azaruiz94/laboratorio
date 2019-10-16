package com.fiuni.sd.domain.analisis;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fiuni.sd.domain.base.BaseDomain;
import com.fiuni.sd.domain.sexo.SexoDomain;
import com.fiuni.sd.domain.tipo_analisis.TipoAnalisisDomain;
import com.fiuni.sd.domain.valor_referencia.ValorReferenciaDomain;
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
	private ValorReferenciaDomain _valorReferencia;
	@Column(name = "tipo_analisis_id", nullable = false)
	private TipoAnalisisDomain _tipoAnalisis;
	@Column(name = "sexo_id", nullable = false)
	private SexoDomain _sexo;


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
	
	public ValorReferenciaDomain getValorReferencia() {
		return _valorReferencia;
	}

	public void setValorReferencia(ValorReferenciaDomain valorReferencia) {
		_valorReferencia = valorReferencia;
	}
	
	public TipoAnalisisDomain getTipoAnalisisId() {
		return _tipoAnalisis;
	}

	public void setTipoAnalisisId(TipoAnalisisDomain tipoAnalisis) {
		_tipoAnalisis = tipoAnalisis;
	}
	
	public SexoDomain getSexoId() {
		return _sexo;
	}

	public void setSexoId(SexoDomain sexo) {
		_sexo = sexo;
	}

	@Override
	public String toString() {
		return "AnalisisDomain [_id=" + _id + ", _nombre=" + _nombre + ", _valorReferenciaId=" + _valorReferencia + ", _tipoAnalisisId=" + _tipoAnalisis + ", _sexoId=" + _sexo + "]";
	}

}