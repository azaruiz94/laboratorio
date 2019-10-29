package com.fiuni.sd.service.usuario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.dao.usuario.IUsuarioDao;
import com.fiuni.sd.domain.credenciales.usuario.UsuarioDomain;
import com.fiuni.sd.dto.usuario.UsuarioDTO;
import com.fiuni.sd.dto.usuario.UsuarioResult;
import com.fiuni.sd.service.base.BaseServiceImpl;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<UsuarioDTO, UsuarioDomain, UsuarioResult> implements IUsuarioService  {
	@Autowired
	IUsuarioDao usuarioDao;

	@Override
	@Transactional
	public UsuarioDTO save(UsuarioDTO dto) {
		final UsuarioDomain domain = convertDtoToDomain(dto);
		final UsuarioDomain usuarioDomain = usuarioDao.save(domain);
		return convertDomainToDto(usuarioDomain);
	}

	@Override
	@Transactional
	public UsuarioDTO getById(Integer id) {
		final UsuarioDomain domain = usuarioDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	public UsuarioResult getAll(Pageable pageable) {
		final List<UsuarioDTO> usuarios = new ArrayList<>();
		Page<UsuarioDomain> resultados = usuarioDao.findAll(pageable);
		resultados.forEach(e -> usuarios.add(convertDomainToDto(e)));
		
		UsuarioResult usuariosResult = new UsuarioResult();
		usuariosResult.setUsuarios(usuarios);
		return usuariosResult;
	}
	
	@Override
	protected UsuarioDTO convertDomainToDto(UsuarioDomain domain) {
		final UsuarioDTO dto = new UsuarioDTO();
		dto.setId(domain.getId());
		return dto;
	}

	@Override
	protected UsuarioDomain convertDtoToDomain(UsuarioDTO dto) {
		final UsuarioDomain domain = new UsuarioDomain();
		domain.setId(dto.getId());
		return domain;
	}

	@Override
	public UsuarioResult getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UsuarioDTO update(Integer id, UsuarioDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioResult search(Pageable pageable, String texto) {
		// TODO Auto-generated method stub
		return null;
	}


}