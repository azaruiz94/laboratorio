package com.fiuni.sd.service.iva;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.dao.iva.IIvaDao;
import com.fiuni.sd.domain.iva.IvaDomain;
import com.fiuni.sd.dto.iva.IvaDTO;
import com.fiuni.sd.dto.iva.IvaResult;
import com.fiuni.sd.service.base.BaseServiceImpl;
import com.fiuni.sd.utils.Configuracion;


@Service
public class IvaServiceImpl extends BaseServiceImpl<IvaDTO, IvaDomain, IvaResult> implements IIvaService {

	@Override
	@Transactional
	public IvaDTO save(IvaDTO dto) {
		final IvaDomain domain = convertDtoToDomain(dto);
		final IvaDomain ivaDomain = ivaDao.save(domain);
		IvaDTO ivaDto = convertDomainToDto(ivaDomain);
		if(null == ivaDto.getId()) {
			cacheManager.getCache(config.getCacheName()).put(formatCacheKey("ivaDomain", ivaDto.getId()), ivaDto);
		}
		
		return ivaDto;
	}

	@Override
	@Transactional
	@Cacheable(value = "api_laboratorio_cache", key = "'api_ivaDomain' + #id")
	public IvaDTO getById(Integer id) {
		final IvaDomain domain = ivaDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	public IvaResult getAll(Pageable pageable) {
		final List<IvaDTO> ivas = new ArrayList<>();
		Page<IvaDomain> resultados = ivaDao.findAll(pageable);
		resultados.forEach(e -> {
			IvaDTO ivaDto = convertDomainToDto(e);
			ivas.add(ivaDto);
			cacheManager.getCache(config.getCacheName()).put(formatCacheKey("ivaDomain", ivaDto.getId()), ivaDto);
		});
		IvaResult ivaResult = new IvaResult();
		ivaResult.setIvas(ivas);
		return ivaResult;
	}
	
	@Override
	public void delete(Integer id) {
		ivaDao.deleteById(id);
	}
	
	public IvaDTO update(Integer id, IvaDTO dto) {
		IvaDomain domain = ivaDao.findById(id).get();
		domain.set_id(dto.getId());
		domain.setValor(dto.getValor());
		IvaDomain ivaActualizado = ivaDao.save(domain);
		return convertDomainToDto(ivaActualizado);
	}
	
	public String formatCacheKey(String domain, Integer id) {
		String base = "api_";
		return base + domain + "_" + id;
	}
	
	@Override
	protected IvaDTO convertDomainToDto(IvaDomain domain) {
		final IvaDTO dto = new IvaDTO();
		dto.setId(domain.get_id());
		dto.setValor(domain.getValor());
		return dto;
	}

	@Override
	protected IvaDomain convertDtoToDomain(IvaDTO dto) {
		final IvaDomain domain = new IvaDomain();
		domain.set_id(dto.getId());
		domain.setValor(dto.getValor());
		return domain;
	}

	@Autowired
	private IIvaDao ivaDao;
	
	@Autowired
	CacheManager cacheManager;
	
	@Autowired
	Configuracion config;

	@Override
	public IvaResult search(Pageable pageable, String texto) {
		// TODO Auto-generated method stub
		return null;
	}
}
