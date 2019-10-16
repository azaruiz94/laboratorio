package com.fiuni.sd.domain.solicitud_detalle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fiuni.sd.domain.analisis.AnalisisDomain;
import com.fiuni.sd.domain.base.BaseDomain;
import com.fiuni.sd.domain.credenciales.usuario.UsuarioDomain;
import com.fiuni.sd.domain.solicitud.SolicitudDomain;

@Entity
@Table(name="solicitud_detalle")
public class SolicitudDetalleDomain implements BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@ManyToOne
	private SolicitudDomain _solicitud;
	@Column(name = "analisis_id")
	private AnalisisDomain _analisis;
	@Column(name = "valor_obtenido")
	private String _valorObtenido;
	@Column(name = "bioquimico", nullable = true)
	private UsuarioDomain _bioquimico;
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		this._id = id;
	}
	
	public SolicitudDomain getSolicitud() {
		return _solicitud;
	}

	public void setSolicitud(SolicitudDomain solicitud) {
		_solicitud = solicitud;
	}
	
	public AnalisisDomain getAnalisis() {
		return _analisis;
	}
	
	public void setAnalisisId(AnalisisDomain analisis) {
		_analisis= analisis;
	}
	
	public String getValorObtenido() {
		return _valorObtenido;
	}
	
	public void setValorObtenido(String valorObtenido) {
		_valorObtenido= valorObtenido;
	}
	
	public UsuarioDomain getBioquimico() {
		return _bioquimico;
	}
	
	public void setBioquimico(UsuarioDomain bioquimico) {
		_bioquimico= bioquimico;
	}

}
