package com.fiuni.sd.domain.credenciales.usuario;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

	@Column(name = "nombre")
	private String _nombre;

	@Column(name = "persona_id")
	private Integer _personaId;

	@Column(name = "estado_id")
	private Integer _estadoId;

	@Column(name = "contrasena")
	private String _password;

	@ManyToMany(cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE
		})
	@JoinTable(name = "rol_usuario", 
	joinColumns = @JoinColumn(name = "usuario_id"), 
	inverseJoinColumns = @JoinColumn(name = "rol_id"))
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
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (encoder.matches(password, _password)) {
			this._password = password;
		} else {
			this._password = encoder.encode(password);
		}
	}

	public Set<RolDomain> getRoles() {
		return _roles;
	}

	public void setRoles(Set<RolDomain> rolesIds) {
		this._roles = rolesIds;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + _id + ", nombre=" + _nombre + ", password=" + _password + ", persona=" + _personaId
				+ ", estadoId=" + _estadoId + "]";
	}

}
