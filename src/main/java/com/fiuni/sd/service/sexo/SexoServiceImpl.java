package com.fiuni.sd.service.sexo;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.dao.sexo.ISexoDao;
import com.fiuni.sd.domain.sexo.SexoDomain;
import com.fiuni.sd.dto.sexo.SexoDTO;
import com.fiuni.sd.dto.sexo.SexoResult;
import com.fiuni.sd.service.base.BaseServiceImpl;


@Service
public class SexoServiceImpl extends BaseServiceImpl<SexoDTO, SexoDomain, SexoResult> implements ISexoService {

	@Override
	@Transactional
	public SexoDTO save(SexoDTO dto) {
		final SexoDomain domain = convertDtoToDomain(dto);
		final SexoDomain sexoDomain = sexoDao.save(domain);
		return convertDomainToDto(sexoDomain);
	}

	@Override
	@Transactional
	public SexoDTO getById(Integer id) {
		final SexoDomain domain = sexoDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	public SexoResult getAll(Pageable pageable) {
		final List<SexoDTO> sexos = new ArrayList<>();
		Page<SexoDomain> resultados = sexoDao.findAll(pageable);
		resultados.forEach(e -> sexos.add(convertDomainToDto(e)));
		
		SexoResult sexoResult = new SexoResult();
		sexoResult.setSexos(sexos);
		return sexoResult;
	}
	
	@Override
	public void delete(Integer id) {
		sexoDao.deleteById(id);
	}
	
	public SexoDTO update(Integer id, SexoDTO dto) {
		SexoDomain domain = sexoDao.findById(id).get();
		domain.set_id(dto.getId());
		domain.setDescripcion(dto.getDescripcion());
		SexoDomain sexoActualizado = sexoDao.save(domain);
		return convertDomainToDto(sexoActualizado);
	}
	
	@Override
	protected SexoDTO convertDomainToDto(SexoDomain domain) {
		final SexoDTO dto = new SexoDTO();
		dto.setId(domain.get_id());
		dto.setDescripcion(domain.getDescripcion());
		return dto;
	}

	@Override
	protected SexoDomain convertDtoToDomain(SexoDTO dto) {
		final SexoDomain domain = new SexoDomain();
		domain.set_id(dto.getId());
		domain.setDescripcion(dto.getDescripcion());
		return domain;
	}

	@Autowired
	private ISexoDao sexoDao;

	@Override
	public SexoResult search(Pageable pageable, String texto) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
