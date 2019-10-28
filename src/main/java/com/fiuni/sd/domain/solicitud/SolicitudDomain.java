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
import com.fiuni.sd.domain.centro_asistencial.CentroAsistencialDomain;
import com.fiuni.sd.domain.estado.EstadoDomain;
import com.fiuni.sd.domain.persona.PersonaDomain;
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
	private CentroAsistencialDomain _centroAsistencial;
	@Column(name = "estado_id")
	private EstadoDomain _estado;
	@Column(name = "paciente_id")
	private PersonaDomain _paciente;
	@Column(name = "doctor_id")
	private PersonaDomain _doctor;
	
	@OneToMany(mappedBy = "_solicitud")
	private Set<SolicitudDetalleDomain> _solicitudDetalles = new HashSet<>();
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		this._id = id;
	}
	
	public CentroAsistencialDomain getCentroAsistencial() {
		return _centroAsistencial;
	}
	
	public void setCentroAsistencial(CentroAsistencialDomain centroAsistencial) {
		_centroAsistencial= centroAsistencial;
	}
	
	public EstadoDomain getEstado() {
		return _estado;
	}
	
	public void setEstado(EstadoDomain estado) {
		_estado= estado;
	}
	
	public PersonaDomain getPaciente() {
		return _paciente;
	}
	
	public void setPaciente(PersonaDomain paciente) {
		_paciente= paciente;
	}
	
	public PersonaDomain getDoctor() {
		return _doctor;
	}
	
	public void setDoctor(PersonaDomain doctor) {
		_doctor= doctor;
	}
	
	public Set<SolicitudDetalleDomain> getDetalles() {
		return _solicitudDetalles;
	}

	public void setDetalles(Set<SolicitudDetalleDomain> detalles) {
		this._solicitudDetalles = detalles;
	}

}
