package com.fiuni.sd.service.pais;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.dao.ubicacion.pais.IPaisDao;
import com.fiuni.sd.domain.ubicacion.pais.PaisDomain;
import com.fiuni.sd.dto.ubicacion.pais.PaisDTO;
import com.fiuni.sd.dto.ubicacion.pais.PaisResult;
import com.fiuni.sd.service.base.BaseServiceImpl;
import com.fiuni.sd.utils.Configuracion;

@Service
public class PaisServiceImpl extends BaseServiceImpl<PaisDTO, PaisDomain, PaisResult> implements IPaisService {
	@Autowired
	private IPaisDao paisDao;

	@Autowired
	CacheManager cacheManager;
	
	@Autowired
	Configuracion config;

	@Override
	@Transactional
	public PaisDTO save(PaisDTO dto) {
		final PaisDomain domain = convertDtoToDomain(dto);
		final PaisDomain paisDomain = paisDao.save(domain);
		PaisDTO paisDto = convertDomainToDto(paisDomain);
		if(null == paisDto.getId()) {
			cacheManager.getCache(config.getCacheName()).put(formatCacheKey("paisDomain", paisDto.getId()), paisDto);
		}
		
		return paisDto;
	}

	@Override
	@Transactional
	@Cacheable(value = "api_laboratorio_cache", key = "'api_paisDomain' + #id")
	public PaisDTO getById(Integer id) {
		final PaisDomain domain = paisDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	@Transactional
	public PaisResult find(String textToFind) {
		final List<PaisDTO> paises = new ArrayList<>();
		final PaisResult paisResult = new PaisResult();
		paisResult.setPaises(paises);
		return paisResult;
	}

	@Override
	protected PaisDTO convertDomainToDto(PaisDomain domain) {
		final PaisDTO dto = new PaisDTO();
		dto.setId(domain.getId());
		dto.setNombre(domain.getNombre());
		return dto;
	}

	@Override
	protected PaisDomain convertDtoToDomain(PaisDTO dto) {
		final PaisDomain domain = new PaisDomain();
		domain.setId(dto.getId());
		domain.setNombre(dto.getNombre());
		return domain;
	}

	@Override
	public PaisResult getAll(Pageable pageable) {
		final List<PaisDTO> paises = new ArrayList<>();
		Page<PaisDomain> resultados = paisDao.findAll(pageable);
		resultados.forEach(e -> {
			PaisDTO paisDto = convertDomainToDto(e);
			paises.add(paisDto);
			cacheManager.getCache(config.getCacheName()).put(formatCacheKey("paisDomain", paisDto.getId()), paisDto);
		});
		
		PaisResult paisResult = new PaisResult();
		paisResult.setPaises(paises);
		return paisResult;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaisDTO update(Integer id, PaisDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaisResult search(Pageable pageable, String texto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String formatCacheKey(String domain, Integer id) {
		String base = "api_";
		return base + domain + "_" + id;
	}
}