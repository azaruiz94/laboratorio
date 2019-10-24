package com.fiuni.sd.domain.valor_referencia;

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
import com.fiuni.sd.domain.analisis.AnalisisDomain;
import com.fiuni.sd.domain.metrica.MetricaDomain;

@Entity
@Table(name = "valorReferencia")
public class ValorReferenciaDomain implements BaseDomain {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "min")
	private String _min;
	
	@Column(name = "max")
	private String _max;
	
	@ManyToOne
	private MetricaDomain _metrica;

	@OneToMany(mappedBy="_valorReferencia")
	private Set<AnalisisDomain>_analisis= new HashSet<>();
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}
	
	public String getMin() {
		return _min;
	}

	public void setMin(String min) {
		_min = min;
	}
	
	public String getMax() {
		return _max;
	}

	public void setMax(String max) {
		_max = max;
	}
	
	public MetricaDomain getMetrica() {
		return _metrica;
	}

	public void setMetrica(MetricaDomain metrica) {
		_metrica = metrica;
	}

	public Set<AnalisisDomain> getAnalisis() {
		return _analisis;
	}

	public void setAnalisis(Set<AnalisisDomain> analisis) {
		_analisis = analisis;
	}

	@Override
	public String toString() {
		return "ValorReferenciaDomain [_id=" + _id + ", _min=" + _min + ", _max=" + _max + ", _metrica=" + _metrica+ ", _analisis=" + _analisis + "]";
	}
}