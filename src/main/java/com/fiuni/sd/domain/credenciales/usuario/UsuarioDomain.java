package com.fiuni.sd.domain.credenciales.usuario;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fiuni.sd.domain.base.BaseDomain;
import com.fiuni.sd.domain.credenciales.rol.RolDomain;

@Entity
@Table(name = "usuario")
public class UsuarioDomain implements BaseDomain {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer _id;

	@Column(name= "nombre")
	private String _nombre;
	@Column(name= "persona_id")
	private Integer _personaId;
	@Column(name= "estado_id")
	private Integer _estadoId;
	@Column(name= "contrasena")
	private String _password;
	
	@Transient
	private String _confirmPassword;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "rol_usuario", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<RolDomain> _roles;

	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		this._id = id;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String username) {
		this._nombre = username;
	}
	
	public Integer getPersonaId() {
		return _personaId;
	}

	public void setPersonaID(Integer personaId) {
		this._personaId = personaId;
	}
	
	public Integer getEstadoId() {
		return _estadoId;
	}

	public void setEstadoId(Integer estadoId) {
		this._estadoId = estadoId;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		this._password = password;
	}

	public String getConfirmPassword() {
		return _confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this._confirmPassword = confirmPassword;
	}

	public Set<RolDomain> getRoles() {
		return _roles;
	}

	public void setRoles(Set<RolDomain> roles) {
		this._roles = roles;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + _id + ", nombre=" + _nombre + ", password=" + _password + ", roles=" + _roles + ", personaId=" + _personaId+ ", estadoId=" + _estadoId+ "]";
	}

}
