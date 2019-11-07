package com.fiuni.sd.service.solicitud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.dao.persona.IPersonaDao;
import com.fiuni.sd.dao.solicitud.ISolicitudDao;
import com.fiuni.sd.domain.solicitud.SolicitudDomain;
import com.fiuni.sd.dto.solicitud.SolicitudDTO;
import com.fiuni.sd.dto.solicitud.SolicitudResult;
import com.fiuni.sd.service.base.BaseServiceImpl;

@Service
public class SolicitudServiceImpl extends BaseServiceImpl<SolicitudDTO, SolicitudDomain, SolicitudResult> implements ISolicitudService {
	@Autowired
	private IPersonaDao doctorDao;
	@Autowired
	private ISolicitudDao solicitudDao;

	@Override
	@Transactional
	public SolicitudDTO save(SolicitudDTO dto) {
		final SolicitudDomain domain = convertDtoToDomain(dto);
		final SolicitudDomain solicitudDomain = solicitudDao.save(domain);
		return convertDomainToDto(solicitudDomain);
	}

	@Override
	@Transactional
	public SolicitudDTO getById(Integer id) {
		final SolicitudDomain domain = solicitudDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	@Transactional
	public SolicitudResult find(String textToFind) {
		final List<SolicitudDTO> solicitudes = new ArrayList<>();
		final SolicitudResult solicitudResult = new SolicitudResult();
		solicitudResult.setSolicitudes(solicitudes);;
		return solicitudResult;
	}

	@Override
	protected SolicitudDTO convertDomainToDto(SolicitudDomain domain) {
		final SolicitudDTO dto = new SolicitudDTO();
		dto.setId(domain.getId());
		dto.setDoctorId(domain.getDoctor().getId());
		return dto;
	}

	@Override
	protected SolicitudDomain convertDtoToDomain(SolicitudDTO dto) {
		final SolicitudDomain domain = new SolicitudDomain();
		domain.setId(dto.getId());
		domain.setDoctor(doctorDao.findById(dto.getDoctorId()).get());
		return domain;
	}

	@Override
	public SolicitudResult getAll(Pageable pageable) {
		final List<SolicitudDTO> solicitudes = new ArrayList<>();
		Page<SolicitudDomain> resultados = solicitudDao.findAll(pageable);
		resultados.forEach(e -> solicitudes.add(convertDomainToDto(e)));
		SolicitudResult solicitudResult = new SolicitudResult();
		solicitudResult.setSolicitudes(solicitudes);
		return solicitudResult;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SolicitudDTO update(Integer id, SolicitudDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SolicitudResult search(Pageable pageable, String texto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String formatCacheKey(String domain, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}