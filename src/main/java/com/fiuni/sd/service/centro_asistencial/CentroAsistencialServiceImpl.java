package com.fiuni.sd.service.centro_asistencial;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.dao.centro_asistencial.ICentroAsistencialDao;
import com.fiuni.sd.domain.centro_asistencial.CentroAsistencialDomain;
import com.fiuni.sd.dto.centro_asistencial.CentroAsistencialDTO;
import com.fiuni.sd.dto.centro_asistencial.CentroAsistencialResult;
import com.fiuni.sd.service.base.BaseServiceImpl;

@Service
public class CentroAsistencialServiceImpl extends BaseServiceImpl<CentroAsistencialDTO, CentroAsistencialDomain, CentroAsistencialResult> implements ICentroAsistencialService {

	@Override
	@Transactional
	public CentroAsistencialDTO save(CentroAsistencialDTO dto) {
		final CentroAsistencialDomain domain = convertDtoToDomain(dto);
		final CentroAsistencialDomain estadoDomain = _tipoAnalisisDao.save(domain);
		return convertDomainToDto(estadoDomain);
	}

	@Override
	@Transactional
	public CentroAsistencialDTO getById(Integer id) {
		final CentroAsistencialDomain domain = _tipoAnalisisDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	public CentroAsistencialResult getAll(Pageable pageable) {
		final List<CentroAsistencialDTO> tipos_analisis = new ArrayList<>();
		Page<CentroAsistencialDomain> resultados = _tipoAnalisisDao.findAll(pageable);
		resultados.forEach(e -> tipos_analisis.add(convertDomainToDto(e)));
		
		CentroAsistencialResult tipoAnalisisResult = new CentroAsistencialResult();
		tipoAnalisisResult.setTiposAnalisis(tipos_analisis);
		return tipoAnalisisResult;
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
	private ICentroAsistencialDao _tipoAnalisisDao;

	@Override
	public CentroAsistencialDTO delete(CentroAsistencialDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
}