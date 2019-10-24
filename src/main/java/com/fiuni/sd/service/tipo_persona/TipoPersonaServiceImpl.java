package com.fiuni.sd.service.tipo_persona;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.dao.tipo_persona.ITipoPersonaDao;
import com.fiuni.sd.domain.tipo_persona.TipoPersonaDomain;
import com.fiuni.sd.dto.tipo_persona.TipoPersonaDTO;
import com.fiuni.sd.dto.tipo_persona.TipoPersonaResult;
import com.fiuni.sd.service.base.BaseServiceImpl;

@Service
public class TipoPersonaServiceImpl extends BaseServiceImpl<TipoPersonaDTO, TipoPersonaDomain, TipoPersonaResult> implements ITipoPersonaService {

	@Override
	@Transactional
	public TipoPersonaDTO save(TipoPersonaDTO dto) {
		final TipoPersonaDomain domain = convertDtoToDomain(dto);
		final TipoPersonaDomain estadoDomain = tipoPersonaDao.save(domain);
		return convertDomainToDto(estadoDomain);
	}

	@Override
	@Transactional
	public TipoPersonaDTO getById(Integer id) {
		final TipoPersonaDomain domain = tipoPersonaDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	public TipoPersonaResult getAll(Pageable pageable) {
		final List<TipoPersonaDTO> tipoPersonas = new ArrayList<>();
		Page<TipoPersonaDomain> resultados = tipoPersonaDao.findAll(pageable);
		resultados.forEach(e -> tipoPersonas.add(convertDomainToDto(e)));
		
		TipoPersonaResult tipoPersonaResult = new TipoPersonaResult();
		tipoPersonaResult.setTipoPersonas(tipoPersonas);
		return tipoPersonaResult;
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

	@Autowired
	private ITipoPersonaDao tipoPersonaDao;

	@Override
	public TipoPersonaDTO delete(TipoPersonaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
