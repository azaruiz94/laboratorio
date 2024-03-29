package com.fiuni.sd.service.analisis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.dao.analisis.IAnalisisDao;
import com.fiuni.sd.domain.analisis.AnalisisDomain;
import com.fiuni.sd.dto.analisis.AnalisisDTO;
import com.fiuni.sd.dto.analisis.AnalisisResult;
import com.fiuni.sd.service.base.BaseServiceImpl;
import com.fiuni.sd.utils.Configuracion;

@Service
public class AnalisisServiceImpl extends BaseServiceImpl<AnalisisDTO, AnalisisDomain, AnalisisResult>
		implements IAnalisisService {

	@Override
	@Transactional
	public AnalisisDTO save(AnalisisDTO dto) {
		final AnalisisDomain domain = convertDtoToDomain(dto);
		final AnalisisDomain analisisDomain = analisisDao.save(domain);
		AnalisisDTO analisisDto = convertDomainToDto(analisisDomain);
		if (null == analisisDto.getId()) {
			cacheManager.getCache(config.getCacheName()).put(formatCacheKey("analisisDomain", analisisDto.getId()),
					analisisDto);
		}

		return analisisDto;
	}

	@Override
	@Transactional
	@Cacheable(value = "api_laboratorio_cache", key = "'api_analisisDomain' + #id")
	public AnalisisDTO getById(Integer id) {
		final AnalisisDomain domain = analisisDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	public AnalisisResult getAll(Pageable pageable) {
		final List<AnalisisDTO> analisis = new ArrayList<>();
		Page<AnalisisDomain> resultados = analisisDao.findAll(pageable);
		resultados.forEach(e -> {
			AnalisisDTO analisisDto = convertDomainToDto(e);
			analisis.add(analisisDto);
			cacheManager.getCache(config.getCacheName()).put(formatCacheKey("analisisDomain", analisisDto.getId()),
					analisisDto);
		});

		AnalisisResult analisisResult = new AnalisisResult();
		analisisResult.setListaAnalisis(analisis);
		return analisisResult;
	}

	@Override
	protected AnalisisDTO convertDomainToDto(AnalisisDomain domain) {
		final AnalisisDTO dto = new AnalisisDTO();
		dto.setId(domain.getId());
		dto.setNombre(domain.getNombre());
		return dto;
	}

	@Override
	protected AnalisisDomain convertDtoToDomain(AnalisisDTO dto) {
		final AnalisisDomain domain = new AnalisisDomain();
		domain.setId(dto.getId());
		domain.setNombre(dto.getNombre());
		return domain;
	}

	@Autowired
	private IAnalisisDao analisisDao;

	@Autowired
	CacheManager cacheManager;

	@Autowired
	Configuracion config;

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public AnalisisDTO update(Integer id, AnalisisDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnalisisResult search(Pageable pageable, String texto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String formatCacheKey(String domain, Integer id) {
		String base = "api_";
		return base + domain + "_" + id;
	}

}