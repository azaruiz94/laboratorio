package com.fiuni.sd.service.tipo_persona;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.dao.tipo_persona.ITipoPersonaDao;
import com.fiuni.sd.domain.tipo_persona.TipoPersonaDomain;
import com.fiuni.sd.dto.tipo_persona.TipoPersonaDTO;
import com.fiuni.sd.dto.tipo_persona.TipoPersonaResult;
import com.fiuni.sd.service.base.BaseServiceImpl;
import com.fiuni.sd.utils.Configuracion;

@Service
public class TipoPersonaServiceImpl extends BaseServiceImpl<TipoPersonaDTO, TipoPersonaDomain, TipoPersonaResult> implements ITipoPersonaService {

	@Override
	@Transactional
	public TipoPersonaDTO save(TipoPersonaDTO dto) {
		final TipoPersonaDomain domain = convertDtoToDomain(dto);
		final TipoPersonaDomain tipoPersonaDomain = tipoPersonaDao.save(domain);
		TipoPersonaDTO tipoPersonaDto = convertDomainToDto(tipoPersonaDomain);
		if(null == tipoPersonaDto.getId()) {
			cacheManager.getCache(config.getCacheName()).put(formatCacheKey("tipoPersonaDomain", tipoPersonaDto.getId()), tipoPersonaDto);
		}
		
		return tipoPersonaDto;
	}

	@Override
	@Transactional
	@Cacheable(value = "api_laboratorio_cache", key = "'api_tipoPersonaDomain' + #id")
	public TipoPersonaDTO getById(Integer id) {
		final TipoPersonaDomain domain = tipoPersonaDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	public TipoPersonaResult getAll(Pageable pageable) {
		final List<TipoPersonaDTO> tipoPersonas = new ArrayList<>();
		Page<TipoPersonaDomain> resultados = tipoPersonaDao.findAll(pageable);
		resultados.forEach(e ->{ 
			TipoPersonaDTO tipoPersonaDto = convertDomainToDto(e);
			tipoPersonas.add(tipoPersonaDto);
		cacheManager.getCache(config.getCacheName()).put(formatCacheKey("tipoPersonaDomain", tipoPersonaDto.getId()), tipoPersonaDto);
		});
		TipoPersonaResult tipoPersonaResult = new TipoPersonaResult();
		tipoPersonaResult.setTipoPersonas(tipoPersonas);
		return tipoPersonaResult;
	}
	
	@Override
	public void delete(Integer id) {
		tipoPersonaDao.deleteById(id);
	}
	
	@Override
	public TipoPersonaDTO update(Integer id, TipoPersonaDTO dto) {
		TipoPersonaDomain domain = tipoPersonaDao.findById(id).get();
		domain.set_id(dto.getId());
		domain.setDescripcion(dto.getDescripcion());
		TipoPersonaDomain tipoPersonaActualizado = tipoPersonaDao.save(domain);
		return convertDomainToDto(tipoPersonaActualizado);
	}
	
	@Override
	protected TipoPersonaDTO convertDomainToDto(TipoPersonaDomain domain) {
		final TipoPersonaDTO dto = new TipoPersonaDTO();
		dto.setId(domain.get_id());
		dto.setDescripcion(domain.getDescripcion());
		return dto;
	}

	@Override
	protected TipoPersonaDomain convertDtoToDomain(TipoPersonaDTO dto) {
		final TipoPersonaDomain domain = new TipoPersonaDomain();
		domain.set_id(dto.getId());
		domain.setDescripcion(dto.getDescripcion());
		return domain;
	}
	
	@Override
	public String formatCacheKey(String domain, Integer id) {
		String base = "api_";
		return base + domain + "_" + id;
	}

	@Autowired
	private ITipoPersonaDao tipoPersonaDao;
	
	@Autowired
	CacheManager cacheManager;
	
	@Autowired
	Configuracion config;

	@Override
	public TipoPersonaResult search(Pageable pageable, String texto) {
		// TODO Auto-generated method stub
		return null;
	}
}
