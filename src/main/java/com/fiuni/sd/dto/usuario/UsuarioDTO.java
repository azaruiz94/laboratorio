package com.fiuni.sd.dto.usuario;
import com.fiuni.sd.dto.base.BaseDTO;

public class UsuarioDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	private String _nombre;
	private Integer _persona;
	private Integer _estado;
	private String _password;

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		this._nombre = nombre;
	}

	public Integer getPersonaId() {
		return _persona;
	}

	public void setPersonaID(Integer persona) {
		this._persona = persona;
	}
	
	public Integer getEstadoId() {
		return _estado;
	}

	public void setEstadoId(Integer estado) {
		this._estado = estado;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		this._password = password;
	}

}