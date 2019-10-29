package com.fiuni.sd.service.tipo_analisis;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.dao.tipo_analisis.ITipoAnalisisDao;
import com.fiuni.sd.domain.tipo_analisis.TipoAnalisisDomain;
import com.fiuni.sd.dto.tipo_analisis.TipoAnalisisDTO;
import com.fiuni.sd.dto.tipo_analisis.TipoAnalisisResult;
import com.fiuni.sd.service.base.BaseServiceImpl;

@Service
public class TipoAnalisisServiceImpl extends BaseServiceImpl<TipoAnalisisDTO, TipoAnalisisDomain, TipoAnalisisResult> implements ITipoAnalisisService {

	@Override
	@Transactional
	public TipoAnalisisDTO save(TipoAnalisisDTO dto) {
		final TipoAnalisisDomain domain = convertDtoToDomain(dto);
		final TipoAnalisisDomain tipoAnalisisDomain = tipoAnalisisDao.save(domain);
		return convertDomainToDto(tipoAnalisisDomain);
	}

	@Override
	@Transactional
	public TipoAnalisisDTO getById(Integer id) {
		final TipoAnalisisDomain domain = tipoAnalisisDao.findById(id).get();
		//TipoAnalisisDomain resultado= tipoAnalisisDao.findById(id).isPresent() ? tipoAnalisisDao.findById(id).get() : null;
		return convertDomainToDto(domain);
		//return convertDomainToDto(resultado);
	}

	@Override
	public TipoAnalisisResult getAll(Pageable pageable) {
		final List<TipoAnalisisDTO> tipos_analisis = new ArrayList<>();
		Page<TipoAnalisisDomain> resultados = tipoAnalisisDao.findAll(pageable);
		resultados.forEach(e -> tipos_analisis.add(convertDomainToDto(e)));
		
		TipoAnalisisResult tipoAnalisisResult = new TipoAnalisisResult();
		tipoAnalisisResult.setTiposAnalisis(tipos_analisis);
		return tipoAnalisisResult;
	}
	
	@Override
	protected TipoAnalisisDTO convertDomainToDto(TipoAnalisisDomain domain) {
		final TipoAnalisisDTO dto = new TipoAnalisisDTO();
		Optional<TipoAnalisisDomain> resultado= Optional.ofNullable(domain);
		if(resultado.isPresent()) {
			dto.setId(resultado.get().getId());
			dto.setNombre(resultado.get().getNombre());
			
		}
		return dto;
	}

	@Override
	protected TipoAnalisisDomain convertDtoToDomain(TipoAnalisisDTO dto) {
		final TipoAnalisisDomain domain = new TipoAnalisisDomain();
		domain.setId(dto.getId());
		domain.setNombre(dto.getNombre());
		return domain;
	}
	
	@Autowired
	private ITipoAnalisisDao tipoAnalisisDao;

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TipoAnalisisDTO update(Integer id, TipoAnalisisDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
}