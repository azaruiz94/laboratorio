package com.fiuni.sd.service.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fiuni.sd.dao.usuario.IUsuarioDao;
import com.fiuni.sd.dto.usuario.UsuarioDTO;
import com.fiuni.sd.dto.usuario.UsuarioResult;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	@Autowired
	IUsuarioDao usuarioDao;

	@Override
	public UsuarioDTO save(UsuarioDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTO getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioResult getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioResult getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTO delete(UsuarioDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}


}