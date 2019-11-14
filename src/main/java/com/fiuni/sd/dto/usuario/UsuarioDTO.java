package com.fiuni.sd.dto.usuario;
import java.util.Set;

import com.fiuni.sd.dto.base.BaseDTO;

public class UsuarioDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;	
	
	private String _nombre;
	private Integer _personaId;
	private Integer _estadoId;
	private String _password;
	private Set<Integer> rolesIds;

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		this._nombre = nombre;
	}

	public Integer getPersonaId() {
		return _personaId;
	}

	public void setPersonaID(Integer persona) {
		this._personaId = persona;
	}
	
	public Integer getEstadoId() {
		return _estadoId;
	}

	public void setEstadoId(Integer estado) {
		this._estadoId = estado;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		this._password = password;
	}

	public Set<Integer> getRolesIds() {
		return rolesIds;
	}

	public void setRolesIds(Set<Integer> rolesIds) {
		this.rolesIds = rolesIds;
	}

}