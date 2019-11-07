package com.fiuni.sd.service.valor_referencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.dao.valor_referencia.IValorReferenciaDao;
import com.fiuni.sd.dao.metrica.IMetricaDao;
import com.fiuni.sd.domain.valor_referencia.ValorReferenciaDomain;
import com.fiuni.sd.dto.valor_referencia.ValorReferenciaDTO;
import com.fiuni.sd.dto.valor_referencia.ValorReferenciaResult;
import com.fiuni.sd.service.base.BaseServiceImpl;
import com.fiuni.sd.utils.Configuracion;

@Service
@Transactional
public class ValorReferenciaServiceImpl extends BaseServiceImpl<ValorReferenciaDTO, ValorReferenciaDomain, ValorReferenciaResult> implements IValorReferenciaService {
	@Autowired
	private IValorReferenciaDao valorReferenciaDao;
	@Autowired
	private IMetricaDao metricaDao;
	
	@Autowired
	CacheManager cacheManager;
	
	@Autowired
	Configuracion config;

	@Override
	public ValorReferenciaDTO save(ValorReferenciaDTO dto) {
		final ValorReferenciaDomain domain = convertDtoToDomain(dto);
		final ValorReferenciaDomain valorReferenciaDomain = valorReferenciaDao.save(domain);
		ValorReferenciaDTO valorReferenciaDto = convertDomainToDto(valorReferenciaDomain);
		if(null == valorReferenciaDto.getId()) {
			cacheManager.getCache(config.getCacheName()).put(formatCacheKey("valorReferenciaDomain", valorReferenciaDto.getId()), valorReferenciaDto);
		}
		
		return valorReferenciaDto;
	}

	@Override
	@Cacheable(value = "api_laboratorio_cache", key = "'api_valorReferenciaDomain' + #id")
	public ValorReferenciaDTO getById(Integer id) {
		final ValorReferenciaDomain valorReferenciaDomain = valorReferenciaDao.findById(id).get();
		return convertDomainToDto(valorReferenciaDomain);
	}

	@Override
	protected ValorReferenciaDTO convertDomainToDto(ValorReferenciaDomain domain) {
		final ValorReferenciaDTO dto = new ValorReferenciaDTO();
		dto.setId(domain.getId());
		dto.setMetricaId(domain.getMetrica().getId());
		dto.setMin(domain.getMin());
		dto.setMax(domain.getMax());
		return dto;
	}

	@Override
	protected ValorReferenciaDomain convertDtoToDomain(ValorReferenciaDTO dto) {
		final ValorReferenciaDomain domain = new ValorReferenciaDomain();
		domain.setId(dto.getId());
		domain.setMetrica(metricaDao.findById(dto.getMetricaId()).get());
		domain.setMin(dto.getMin());
		domain.setMax(dto.getMax());
		return domain;
	}

	@Override
	public ValorReferenciaResult getAll(Pageable pageable) {
		final List<ValorReferenciaDTO> valoresReferencia = new ArrayList<>();
		Page<ValorReferenciaDomain> resultados = valorReferenciaDao.findAll(pageable);
		resultados.forEach(e -> {
			ValorReferenciaDTO valorReferenciaDto = convertDomainToDto(e);
			valoresReferencia.add(valorReferenciaDto);
			cacheManager.getCache(config.getCacheName()).put(formatCacheKey("valorReferenciaDomain", valorReferenciaDto.getId()), valorReferenciaDto);
		});
		
		ValorReferenciaResult valorReferenciaResult = new ValorReferenciaResult();
		valorReferenciaResult.setValorReferencia(valoresReferencia);
		return valorReferenciaResult;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ValorReferenciaDTO update(Integer id, ValorReferenciaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValorReferenciaResult search(Pageable pageable, String texto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String formatCacheKey(String domain, Integer id) {
		String base = "api_";
		return base + domain + "_" + id;
	}
}