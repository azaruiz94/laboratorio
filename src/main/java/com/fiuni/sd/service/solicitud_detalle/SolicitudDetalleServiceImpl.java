package com.fiuni.sd.service.solicitud_detalle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.dao.solicitud_detalle.ISolicitudDetalleDao;
import com.fiuni.sd.domain.solicitud_detalle.SolicitudDetalleDomain;
import com.fiuni.sd.dto.solicitud_detalle.SolicitudDetalleDTO;
import com.fiuni.sd.dto.solicitud_detalle.SolicitudDetalleResult;
import com.fiuni.sd.service.base.BaseServiceImpl;

@Service
public class SolicitudDetalleServiceImpl extends BaseServiceImpl<SolicitudDetalleDTO, SolicitudDetalleDomain, SolicitudDetalleResult> implements ISolicitudDetalleService {
	@Autowired
	private ISolicitudDetalleDao solicitudDetalleDao;

	@Override
	@Transactional
	public SolicitudDetalleDTO save(SolicitudDetalleDTO dto) {
		final SolicitudDetalleDomain domain = convertDtoToDomain(dto);
		final SolicitudDetalleDomain solicitudDetalleDomain = solicitudDetalleDao.save(domain);
		return convertDomainToDto(solicitudDetalleDomain);
	}

	@Override
	@Transactional
	public SolicitudDetalleDTO getById(Integer id) {
		final SolicitudDetalleDomain domain = solicitudDetalleDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	@Transactional
	public SolicitudDetalleResult find(String textToFind) {
		final List<SolicitudDetalleDTO> solicitudDetalles = new ArrayList<>();
		final SolicitudDetalleResult solicitudDetallesResult = new SolicitudDetalleResult();
		solicitudDetallesResult.setSolicitudes(solicitudDetalles);
		return solicitudDetallesResult;
	}

	@Override
	protected SolicitudDetalleDTO convertDomainToDto(SolicitudDetalleDomain domain) {
		final SolicitudDetalleDTO dto = new SolicitudDetalleDTO();
		dto.setId(domain.getId());
		return dto;
	}

	@Override
	protected SolicitudDetalleDomain convertDtoToDomain(SolicitudDetalleDTO dto) {
		final SolicitudDetalleDomain domain = new SolicitudDetalleDomain();
		domain.setId(dto.getId());
		return domain;
	}

	@Override
	public SolicitudDetalleDTO delete(SolicitudDetalleDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SolicitudDetalleResult getAll(Pageable pageable) {
		final List<SolicitudDetalleDTO> solicitudDetalles = new ArrayList<>();
		Page<SolicitudDetalleDomain> resultados = solicitudDetalleDao.findAll(pageable);
		resultados.forEach(e -> solicitudDetalles.add(convertDomainToDto(e)));
		SolicitudDetalleResult solicitudDetallesResult = new SolicitudDetalleResult();
		solicitudDetallesResult.setSolicitudes(solicitudDetalles);
		return solicitudDetallesResult;
	}
}