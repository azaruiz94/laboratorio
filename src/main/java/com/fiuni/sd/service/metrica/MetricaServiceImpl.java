package com.fiuni.sd.service.metrica;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.dao.metrica.IMetricaDao;
import com.fiuni.sd.domain.metrica.MetricaDomain;
import com.fiuni.sd.dto.metrica.MetricaDTO;
import com.fiuni.sd.dto.metrica.MetricaResult;
import com.fiuni.sd.service.base.BaseServiceImpl;
import com.fiuni.sd.utils.Configuracion;


@Service
public class MetricaServiceImpl extends BaseServiceImpl<MetricaDTO, MetricaDomain, MetricaResult> implements IMetricaService {

	@Override
	@Transactional
	public MetricaDTO save(MetricaDTO dto) {
		final MetricaDomain domain = convertDtoToDomain(dto);
		final MetricaDomain metricaDomain = metricaDao.save(domain);
		MetricaDTO metricaDto = convertDomainToDto(metricaDomain);
		if(null == metricaDto.getId()) {
			cacheManager.getCache(config.getCacheName()).put(formatCacheKey("metricaDomain", metricaDto.getId()), metricaDto);
		}
		
		return metricaDto;
	}

	@Override
	@Transactional
	@Cacheable(value = "api_laboratorio_cache", key = "'api_metricaDomain' + #id")
	public MetricaDTO getById(Integer id) {
		final MetricaDomain domain = metricaDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	public MetricaResult getAll(Pageable pageable) {
		final List<MetricaDTO> metricas = new ArrayList<>();
		Page<MetricaDomain> resultados = metricaDao.findAll(pageable);
		resultados.forEach(e -> {
			MetricaDTO metricaDto = convertDomainToDto(e);
			metricas.add(metricaDto);
			cacheManager.getCache(config.getCacheName()).put(formatCacheKey("metricaDomain", metricaDto.getId()), metricaDto);
		});
		
		MetricaResult metricasResult = new MetricaResult();
		metricasResult.setMetricas(metricas);
		return metricasResult;
	}
	
	@Override
	protected MetricaDTO convertDomainToDto(MetricaDomain domain) {
		final MetricaDTO dto = new MetricaDTO();
		dto.setId(domain.getId());
		dto.setUnidadMedida(domain.getUnidadMedida());
		return dto;
	}

	@Override
	protected MetricaDomain convertDtoToDomain(MetricaDTO dto) {
		final MetricaDomain domain = new MetricaDomain();
		domain.setId(dto.getId());
		domain.setUnidadMedida(dto.getUnidadMedida());
		return domain;
	}

	@Autowired
	private IMetricaDao metricaDao;

	@Autowired
	CacheManager cacheManager;
	
	@Autowired
	Configuracion config;

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MetricaDTO update(Integer id, MetricaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MetricaResult search(Pageable pageable, String texto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String formatCacheKey(String domain, Integer id) {
		String base = "api_";
		return base + domain + "_" + id;
	}
	
}