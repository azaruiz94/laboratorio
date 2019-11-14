package com.fiuni.sd.service.usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.dao.rol.IRolDao;
import com.fiuni.sd.dao.usuario.IUsuarioDao;
import com.fiuni.sd.domain.credenciales.rol.RolDomain;
import com.fiuni.sd.domain.credenciales.usuario.UsuarioDomain;
import com.fiuni.sd.dto.usuario.UsuarioDTO;
import com.fiuni.sd.dto.usuario.UsuarioResult;
import com.fiuni.sd.service.base.BaseServiceImpl;
import com.fiuni.sd.utils.Configuracion;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<UsuarioDTO, UsuarioDomain, UsuarioResult> implements IUsuarioService  {
	@Autowired
	IUsuarioDao usuarioDao;
	
	@Autowired
	IRolDao rolDao;
	
	@Autowired
	CacheManager cacheManager;
	
	@Autowired
	Configuracion config;
	
	BCryptPasswordEncoder encoder;

	@Override
	@Transactional
	public UsuarioDTO save(UsuarioDTO dto) {
		final UsuarioDomain domain = convertDtoToDomain(dto);
		final UsuarioDomain usuarioDomain = usuarioDao.save(domain);
		UsuarioDTO usuarioDto = convertDomainToDto(usuarioDomain);
		if(null == usuarioDto.getId()) {
			cacheManager.getCache(config.getCacheName()).put(formatCacheKey("usuarioDomain", usuarioDto.getId()), usuarioDto);
		}
		
		return usuarioDto;
	}

	@Override
	@Transactional
	@Cacheable(value = "api_laboratorio_cache", key = "'api_usuarioDomain' + #id")
	public UsuarioDTO getById(Integer id) {
		final UsuarioDomain domain = usuarioDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	public UsuarioResult getAll(Pageable pageable) {
		final List<UsuarioDTO> usuarios = new ArrayList<>();
		Page<UsuarioDomain> resultados = usuarioDao.findAll(pageable);
		resultados.forEach(e -> {
			UsuarioDTO usuarioDto = convertDomainToDto(e);
			usuarios.add(usuarioDto);
			cacheManager.getCache(config.getCacheName()).put(formatCacheKey("usuarioDomain", usuarioDto.getId()), usuarioDto);
		});
		
		UsuarioResult usuariosResult = new UsuarioResult();
		usuariosResult.setUsuarios(usuarios);
		return usuariosResult;
	}
	
	@Override
	protected UsuarioDTO convertDomainToDto(UsuarioDomain domain) {
		final UsuarioDTO dto = new UsuarioDTO();
		Set<Integer> rolesIds = new HashSet<>();
		
		dto.setEstadoId(domain.getEstadoId());
		dto.setId(domain.getId());
		dto.setNombre(domain.getNombre());
		dto.setPassword(domain.getPassword());
		dto.setPersonaID(domain.getPersonaId());
		
		for (RolDomain e : domain.getRoles()) {
			rolesIds.add(e.getId());
		}
		
		dto.setRolesIds(rolesIds);
		return dto;
	}

	@Override
	protected UsuarioDomain convertDtoToDomain(UsuarioDTO dto) {
		final UsuarioDomain domain = new UsuarioDomain();
		Set<RolDomain> rolesIds = new HashSet<>();
		
		domain.setEstadoId(dto.getEstadoId());
		domain.setId(dto.getId());
		domain.setNombre(dto.getNombre());
		domain.setPassword(encoder.encode(dto.getPassword()));
		domain.setPersonaID(dto.getPersonaId());
		
		for (Integer e : dto.getRolesIds()) {
			rolesIds.add(rolDao.findById(e).get());
		}
		
		domain.setRoles(rolesIds);
		
		return domain;
	}

	@Override
	public void delete(Integer id) {
		usuarioDao.deleteById(id);
	}

	@Override
	public UsuarioDTO update(Integer id, UsuarioDTO dto) {
		UsuarioDomain domain = usuarioDao.findById(id).get();
		Set<RolDomain> rolesIds = new HashSet<>();
		
		domain.setEstadoId(dto.getEstadoId());
		domain.setId(dto.getId());
		domain.setNombre(dto.getNombre());
		domain.setPassword(encoder.encode(dto.getPassword()));
		domain.setPersonaID(dto.getPersonaId());
		
		for (Integer e : dto.getRolesIds()) {
			rolesIds.add(rolDao.findById(e).get());
		}
		
		domain.setRoles(rolesIds);
		
		UsuarioDomain usuarioActualizado = usuarioDao.save(domain);
		return convertDomainToDto(usuarioActualizado);
	}

	@Override
	public UsuarioResult search(Pageable pageable, String texto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String formatCacheKey(String domain, Integer id) {
		String base = "api_";
		return base + domain + "_" + id;
	}


}