package com.fiuni.sd.domain.credenciales.rol;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fiuni.sd.domain.base.BaseDomain;
import com.fiuni.sd.domain.credenciales.usuario.UsuarioDomain;

@Entity
@Table(name = "rol")
public class RolDomain implements BaseDomain{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "rol", nullable = false, length = 50, unique = true)
	private String _rol;
	
	@ManyToMany(mappedBy = "_roles")
    private Set<UsuarioDomain> _usuariosIds = new HashSet<>();
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer _id) {
		this._id = _id;
	}

	public String getRol() {
		return _rol;
	}

	public void setRol(String _rol) {
		this._rol = _rol;
	}
	

	public Set<UsuarioDomain> getUsuarioIds() {
		return _usuariosIds;
	}

	public void setUsuarioIds(Set<UsuarioDomain> usuarioIds) {
		this._usuariosIds = usuarioIds;
	}	
	
}