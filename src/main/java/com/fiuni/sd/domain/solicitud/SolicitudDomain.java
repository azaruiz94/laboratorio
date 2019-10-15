package com.fiuni.sd.domain.solicitud;

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
import com.fiuni.sd.domain.solicitud_detalle.SolicitudDetalleDomain;

@Entity
@Table(name="solicitud")
public class SolicitudDomain implements BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	@Column(name = "centro_asistencial_id")
	private Integer _centroAsistencialID;
	@Column(name = "estado_id")
	private Integer _estadoId;
	@Column(name = "paciente_id")
	private Integer _pacienteId;
	@Column(name = "doctor_id")
	private Integer _doctorId;
	
	@OneToMany(mappedBy = "_solicitud")
	private Set<SolicitudDetalleDomain> _solicitudDetalles = new HashSet<>();
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		this._id = id;
	}
	
	public Integer getCentroAsistencialId() {
		return _centroAsistencialID;
	}
	
	public void setCentroAsistencialId(Integer centroAsistencialId) {
		_centroAsistencialID= centroAsistencialId;
	}
	
	public Integer getEstadoId() {
		return _estadoId;
	}
	
	public void setEstadoId(Integer estadoId) {
		_estadoId= estadoId;
	}
	
	public Integer getPacienteId() {
		return _pacienteId;
	}
	
	public void setPacienteId(Integer pacienteId) {
		_estadoId= pacienteId;
	}
	
	public Integer getDoctorId() {
		return _doctorId;
	}
	
	public void setDoctorId(Integer doctorId) {
		_doctorId= doctorId;
	}
	
	public Set<SolicitudDetalleDomain> getDetalles() {
		return _solicitudDetalles;
	}

	public void setDetalles(Set<SolicitudDetalleDomain> detalles) {
		this._solicitudDetalles = detalles;
	}

}
