package com.fiuni.sd.domain.persona;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fiuni.sd.domain.base.BaseDomain;

@Entity
@Table(name = "persona")
public class PersonaDomain implements BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Integer getId() {
		return _id;
	}
	
	public void setId(Integer id) {
		this._id = id;
	}
	
	public Integer getCiudadId() {
		return _ciudadId;
	}
	public void setCiudadId(Integer ciudadId) {
		this._ciudadId = ciudadId;
	}
	public String getNombre() {
		return _nombre;
	}
	public void setNombre(String nombre) {
		this._nombre = nombre;
	}
	public String getRuc_ci() {
		return _ruc_ci;
	}
	public void setRuc_ci(String ruc_ci) {
		this._ruc_ci = ruc_ci;
	}
	public String getEmail() {
		return _email;
	}
	public void setEmail(String email) {
		this._email = email;
	}
	public String getDireccion() {
		return _direccion;
	}
	public void setDireccion(String direccion) {
		this._direccion = direccion;
	}
	public String getTelefono() {
		return _telefono;
	}
	public void setTelefono(String telefono) {
		this._telefono = telefono;
	}
	public int getNumero_registro() {
		return _numero_registro;
	}
	public void setNumero_registro(int numero_registro) {
		this._numero_registro = numero_registro;
	}
	public Integer getSexoId() {
		return _sexoId;
	}
	public void setSexoId(Integer sexoId) {
		this._sexoId = sexoId;
	}
	public List<Integer> getTipoPersonaId() {
		return _tipoPersonaId;
	}
	public void setTipoPersonaId(List<Integer> tipoPersonaId) {
		this._tipoPersonaId = tipoPersonaId;
	}

	@OneToMany
	private List<Integer> _tipoPersonaId;
	
	@Column(name="sexo", nullable= false)
	private Integer _sexoId;
	
	@Column(name="ciudadId", nullable = false)
	private Integer _ciudadId;
	
	@Column(name="nombre")
	private String _nombre;
	
	@Column(name="ruc_ci")
	private String _ruc_ci;
	
	@Column(name="email")
	private String _email;
	
	@Column(name="direccion")
	private String _direccion;
	
	@Column(name="telefono")
	private String _telefono;
	
	@Column(name = "numero_registro")
	private Integer _numero_registro;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
}