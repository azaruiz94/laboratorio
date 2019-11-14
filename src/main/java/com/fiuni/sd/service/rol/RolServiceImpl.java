package com.fiuni.sd.service.rol;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.dao.rol.IRolDao;
import com.fiuni.sd.dao.usuario.IUsuarioDao;
import com.fiuni.sd.domain.credenciales.rol.RolDomain;
import com.fiuni.sd.domain.credenciales.usuario.UsuarioDomain;
import com.fiuni.sd.dto.rol.RolDTO;
import com.fiuni.sd.dto.rol.RolResult;
import com.fiuni.sd.service.base.BaseServiceImpl;
import com.fiuni.sd.utils.Configuracion;


@Service
public class RolServiceImpl extends BaseServiceImpl<RolDTO, RolDomain, RolResult> implements IRolService {

	@Override
	@Transactional
	public RolDTO save(RolDTO dto) {
		final RolDomain domain = convertDtoToDomain(dto);
		final RolDomain rolDomain = rolDao.save(domain);
		RolDTO rolDto = convertDomainToDto(rolDomain);
		if(null == rolDto.getId()) {
			cacheManager.getCache(config.getCacheName()).put(formatCacheKey("rolDomain", rolDto.getId()), rolDto);
		}
		
		return rolDto;
	}

	@Override
	@Transactional
	@Cacheable(value = "api_laboratorio_cache", key = "'api_rolDomain' + #id")
	public RolDTO getById(Integer id) {
		final RolDomain domain = rolDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	public RolResult getAll(Pageable pageable) {
		final List<RolDTO> roles = new ArrayList<>();
		Page<RolDomain> resultados = rolDao.findAll(pageable);
		resultados.forEach(e -> {
			RolDTO rolDto = convertDomainToDto(e);
			roles.add(rolDto);
			cacheManager.getCache(config.getCacheName()).put(formatCacheKey("rolDomain", rolDto.getId()), rolDto);
		});
		RolResult rolResult = new RolResult();
		rolResult.setRoles(roles);
		return rolResult;
	}
	
	@Override
	public void delete(Integer id) {
		rolDao.deleteById(id);
	}
	
	@Override
	public RolDTO update(Integer id, RolDTO dto) {
		RolDomain domain = rolDao.findById(id).get();
		Set<UsuarioDomain> usuarioIds = new HashSet<>();
		
		domain.setId(dto.getId());
		domain.setRol(dto.getRol());
		
		for (Integer e : dto.getUsuarioIds()) {
			usuarioIds.add(usuarioDao.findById(e).get());
		}
		domain.setUsuarioIds(usuarioIds);
		
		RolDomain rolActualizado = rolDao.save(domain);
		return convertDomainToDto(rolActualizado);
	}
	
	@Override
	protected RolDTO convertDomainToDto(RolDomain domain) {
		final RolDTO dto = new RolDTO();
		Set<Integer> usuarioIds = new HashSet<>();
		
		dto.setId(domain.getId());
		dto.setRol(domain.getRol());
		
		for (UsuarioDomain e : domain.getUsuarioIds()) {
			usuarioIds.add(e.getId());
		}
		
		dto.setUsuarioIds(usuarioIds);
		return dto;
	}

	@Override
	protected RolDomain convertDtoToDomain(RolDTO dto) {
		final RolDomain domain = new RolDomain();
		Set<UsuarioDomain> usuarioIds = new HashSet<>();
		
		domain.setId(dto.getId());
		domain.setRol(dto.getRol());
		
		for (Integer e : dto.getUsuarioIds()) {
			usuarioIds.add(usuarioDao.findById(e).get());
		}
		domain.setUsuarioIds(usuarioIds);
		
		return domain;
	}
	
	@Override
	public String formatCacheKey(String domain, Integer id) {
		String base = "api_";
		return base + domain + "_" + id;
	}
	
	@Override
	public RolResult search(Pageable pageable, String texto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Autowired
	private IRolDao rolDao;
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	CacheManager cacheManager;
	
	@Autowired
	Configuracion config;
}