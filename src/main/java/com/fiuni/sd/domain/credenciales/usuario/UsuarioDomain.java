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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fiuni.sd.domain.base.BaseDomain;
import com.fiuni.sd.domain.credenciales.rol.RolDomain;
//import com.fiuni.sd.domain.credenciales.rol.RolDomain;
import com.fiuni.sd.domain.estado.EstadoDomain;
import com.fiuni.sd.domain.persona.PersonaDomain;

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
	private PersonaDomain _persona;
	@Column(name= "estado_id")
	private EstadoDomain _estado;
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
	
	public PersonaDomain getPersonaId() {
		return _persona;
	}

	public void setPersonaID(PersonaDomain persona) {
		this._persona = persona;
	}
	
	public EstadoDomain getEstadoId() {
		return _estado;
	}

	public void setEstadoId(EstadoDomain estado) {
		this._estado = estado;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(encoder.matches(password, _password)) {
			this._password = password;
		}else {
			this._password = encoder.encode(password);
		}
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
		return "Usuario [id=" + _id + ", nombre=" + _nombre + ", password=" + _password  + ", persona=" + _persona+ ", estadoId=" + _estado+ "]";
	}

}
