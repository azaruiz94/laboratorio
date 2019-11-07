package com.fiuni.sd.service.estado;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.dao.estado.IEstadoDao;
import com.fiuni.sd.domain.estado.EstadoDomain;
import com.fiuni.sd.dto.estado.EstadoDTO;
import com.fiuni.sd.dto.estado.EstadoResult;
import com.fiuni.sd.service.base.BaseServiceImpl;
import com.fiuni.sd.utils.Configuracion;


@Service
public class EstadoServiceImpl extends BaseServiceImpl<EstadoDTO, EstadoDomain, EstadoResult> implements IEstadoService {

	@Override
	@Transactional
	public EstadoDTO save(EstadoDTO dto) {
		final EstadoDomain domain = convertDtoToDomain(dto);
		final EstadoDomain estadoDomain = estadoDao.save(domain);
		EstadoDTO estadoDto = convertDomainToDto(estadoDomain);
		if(null == estadoDto.getId()) {
			cacheManager.getCache(config.getCacheName()).put(formatCacheKey("estadoDomain", estadoDto.getId()), estadoDto);
		}
		
		return estadoDto;
	}

	@Override
	@Transactional
	@Cacheable(value = "api_laboratorio_cache", key = "'api_estadoDomain' + #id")
	public EstadoDTO getById(Integer id) {
		final EstadoDomain domain = estadoDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	public EstadoResult getAll(Pageable pageable) {
		final List<EstadoDTO> estados = new ArrayList<>();
		Page<EstadoDomain> resultados = estadoDao.findAll(pageable);
		resultados.forEach(e -> {
			EstadoDTO estadoDto = convertDomainToDto(e);
			estados.add(estadoDto);
			cacheManager.getCache(config.getCacheName()).put(formatCacheKey("estadoDomain", estadoDto.getId()), estadoDto);
		});
		EstadoResult estadoResult = new EstadoResult();
		estadoResult.setEstados(estados);
		return estadoResult;
	}
	
	@Override
	public void delete(Integer id) {
		estadoDao.deleteById(id);
	}
	
	public EstadoDTO update(Integer id, EstadoDTO dto) {
		EstadoDomain domain = estadoDao.findById(id).get();
		domain.set_id(dto.getId());
		domain.setDescripcion(dto.getDescripcion());
		EstadoDomain estadoActualizado = estadoDao.save(domain);
		return convertDomainToDto(estadoActualizado);
	}
	
	@Override
	protected EstadoDTO convertDomainToDto(EstadoDomain domain) {
		final EstadoDTO dto = new EstadoDTO();
		dto.setId(domain.get_id());
		dto.setDescripcion(domain.getDescripcion());
		return dto;
	}

	@Override
	protected EstadoDomain convertDtoToDomain(EstadoDTO dto) {
		final EstadoDomain domain = new EstadoDomain();
		domain.set_id(dto.getId());
		domain.setDescripcion(dto.getDescripcion());
		return domain;
	}
	
	public String formatCacheKey(String domain, Integer id) {
		String base = "api_";
		return base + domain + "_" + id;
	}

	@Autowired
	private IEstadoDao estadoDao;
	
	@Autowired
	CacheManager cacheManager;
	
	@Autowired
	Configuracion config;

	@Override
	public EstadoResult search(Pageable pageable, String texto) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
