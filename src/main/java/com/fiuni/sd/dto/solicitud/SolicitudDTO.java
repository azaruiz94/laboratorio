package com.fiuni.sd.dto.solicitud;

import java.util.HashSet;
import java.util.Set;

import com.fiuni.sd.dto.base.BaseDTO;

public class SolicitudDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer _centroAsistencial;
	private Integer _estado;
	private Integer _paciente;
	private Integer _doctor;
	
	private Set<Integer> _solicitudDetalles = new HashSet<>();
	
	public Integer getCentroAsistencialId() {
		return _centroAsistencial;
	}
	
	public void setCentroAsistencialId(Integer centroAsistencial) {
		_centroAsistencial= centroAsistencial;
	}
	
	public Integer getEstadoId() {
		return _estado;
	}
	
	public void setEstadoId(Integer estado) {
		_estado= estado;
	}
	
	public Integer getPacienteId() {
		return _paciente;
	}
	
	public void setPacienteId(Integer paciente) {
		_paciente= paciente;
	}
	
	public Integer getDoctorId() {
		return _doctor;
	}
	
	public void setDoctorId(Integer doctor) {
		_doctor= doctor;
	}
	
	public Set<Integer> getDetallesId() {
		return _solicitudDetalles;
	}

	public void setDetallesId(Set<Integer> detalles) {
		this._solicitudDetalles = detalles;
	}

}