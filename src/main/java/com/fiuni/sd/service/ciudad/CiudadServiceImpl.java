package com.fiuni.sd.service.ciudad;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fiuni.sd.dao.ubicacion.ciudad.ICiudadDao;
import com.fiuni.sd.dao.ubicacion.departamento.IDepartamentoDao;
import com.fiuni.sd.domain.ubicacion.ciudad.CiudadDomain;
import com.fiuni.sd.dto.ubicacion.ciudad.CiudadDTO;
import com.fiuni.sd.dto.ubicacion.ciudad.CiudadResult;
import com.fiuni.sd.service.base.BaseServiceImpl;

@Service
public class CiudadServiceImpl extends BaseServiceImpl<CiudadDTO, CiudadDomain,  CiudadResult> implements ICiudadService {
	@Autowired
	private ICiudadDao ciudadDao;
	@Autowired
	private IDepartamentoDao departamentoDao;
	
	
	@Override
	@Transactional
	public CiudadDTO save(CiudadDTO dto) {
		final CiudadDomain domain = convertDtoToDomain(dto);
		final CiudadDomain ciudadDomain = ciudadDao.save(domain);
		return convertDomainToDto(ciudadDomain);
	}

	@Override
	@Transactional
	public CiudadDTO getById(Integer id) {
		final CiudadDomain domain = ciudadDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	protected CiudadDTO convertDomainToDto(CiudadDomain domain) {
		final CiudadDTO dto = new CiudadDTO();
		dto.setId(domain.getId());
		dto.setPaisId(domain.getDepartamento().getPais().getId());
		dto.setDepartamentoId(domain.getDepartamento().getId());
		dto.setNombre(domain.getNombre());
		return dto;
	}

	@Override
	protected CiudadDomain convertDtoToDomain(CiudadDTO dto) {
		final CiudadDomain domain = new CiudadDomain();
		domain.setId(dto.getId());
		domain.setDepartamento(departamentoDao.findById(dto.getDepartamentoId()).get());
		domain.setNombre(dto.getNombre());
		return domain;
	}
	
	@Override
	public CiudadResult getAll(org.springframework.data.domain.Pageable pageable) {
		final List<CiudadDTO> ciudades = new ArrayList<>();
		Page<CiudadDomain> resultados = ciudadDao.findAll(pageable);
		resultados.forEach(e -> ciudades.add(convertDomainToDto(e)));
		CiudadResult ciudadResult = new CiudadResult();
		ciudadResult.setCiudades(ciudades);
		return ciudadResult;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CiudadDTO update(Integer id, CiudadDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CiudadResult search(Pageable pageable, String texto) {
		// TODO Auto-generated method stub
		return null;
	}
}