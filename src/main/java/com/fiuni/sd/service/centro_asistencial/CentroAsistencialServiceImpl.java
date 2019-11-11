package com.fiuni.sd.service.centro_asistencial;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.dao.centro_asistencial.ICentroAsistencialDao;
import com.fiuni.sd.domain.centro_asistencial.CentroAsistencialDomain;
import com.fiuni.sd.dto.centro_asistencial.CentroAsistencialDTO;
import com.fiuni.sd.dto.centro_asistencial.CentroAsistencialResult;
import com.fiuni.sd.service.base.BaseServiceImpl;
import com.fiuni.sd.utils.Configuracion;

@Service
public class CentroAsistencialServiceImpl extends BaseServiceImpl<CentroAsistencialDTO, CentroAsistencialDomain, CentroAsistencialResult> implements ICentroAsistencialService {

	@Override
	@Transactional
	public CentroAsistencialDTO save(CentroAsistencialDTO dto) {
		final CentroAsistencialDomain domain = convertDtoToDomain(dto);
		final CentroAsistencialDomain centroAsistencialDomain = centroAsistencialDao.save(domain);
		CentroAsistencialDTO centroAsistencialDto = convertDomainToDto(centroAsistencialDomain);
		if(null == centroAsistencialDto.getId()) {
			cacheManager.getCache(config.getCacheName()).put(formatCacheKey("centroAsistencialDomain", centroAsistencialDto.getId()), centroAsistencialDto);
		}
		
		return centroAsistencialDto;
	}

	@Override
	@Transactional
	@Cacheable(value = "api_laboratorio_cache", key = "'api_centroAsistencialDomain' + #id")
	public CentroAsistencialDTO getById(Integer id) {
		final CentroAsistencialDomain domain = centroAsistencialDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	public CentroAsistencialResult getAll(Pageable pageable) {
		final List<CentroAsistencialDTO> centrosAsistenciales = new ArrayList<>();
		Page<CentroAsistencialDomain> resultados = centroAsistencialDao.findAll(pageable);
		resultados.forEach(e -> {
			CentroAsistencialDTO centroAsistencialDto = convertDomainToDto(e);
			centrosAsistenciales.add(centroAsistencialDto);
			cacheManager.getCache(config.getCacheName()).put(formatCacheKey("centroAsistencialDomain", centroAsistencialDto.getId()), centroAsistencialDto);
		});
		
		CentroAsistencialResult centroAsistencialResult = new CentroAsistencialResult();
		centroAsistencialResult.setCentroAsistenciales(centrosAsistenciales);
		return centroAsistencialResult;
	}
	
	@Override
	protected CentroAsistencialDTO convertDomainToDto(CentroAsistencialDomain domain) {
		final CentroAsistencialDTO dto = new CentroAsistencialDTO();
		dto.setId(domain.getId());
		dto.setNombre(domain.getNombre());
		return dto;
	}

	@Override
	protected CentroAsistencialDomain convertDtoToDomain(CentroAsistencialDTO dto) {
		final CentroAsistencialDomain domain = new CentroAsistencialDomain();
		domain.setId(dto.getId());
		domain.setNombre(dto.getNombre());
		return domain;
	}

	@Autowired
	private ICentroAsistencialDao centroAsistencialDao;

	@Autowired
	CacheManager cacheManager;
	
	@Autowired
	Configuracion config;


	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CentroAsistencialDTO update(Integer id, CentroAsistencialDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CentroAsistencialResult search(Pageable pageable, String texto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String formatCacheKey(String domain, Integer id) {
		String base = "api_";
		return base + domain + "_" + id;
	}
	
}