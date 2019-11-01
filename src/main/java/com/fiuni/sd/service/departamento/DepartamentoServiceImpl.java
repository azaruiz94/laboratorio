package com.fiuni.sd.service.departamento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fiuni.sd.dao.ubicacion.pais.IPaisDao;
import com.fiuni.sd.dao.ubicacion.departamento.IDepartamentoDao;
import com.fiuni.sd.domain.ubicacion.departamento.DepartamentoDomain;
import com.fiuni.sd.dto.ubicacion.departamento.DepartamentoDTO;
import com.fiuni.sd.dto.ubicacion.departamento.DepartamentoResult;
import com.fiuni.sd.service.base.BaseServiceImpl;

@Service
@Transactional
public class DepartamentoServiceImpl extends BaseServiceImpl<DepartamentoDTO, DepartamentoDomain, DepartamentoResult> implements IDepartamentoService {
	@Autowired
	private IDepartamentoDao departamentoDao;
	@Autowired
	private IPaisDao paisDao;

	@Override
	public DepartamentoDTO save(DepartamentoDTO dto) {
		final DepartamentoDomain domain = convertDtoToDomain(dto);
		final DepartamentoDomain departamentoDomain = departamentoDao.save(domain);
		return convertDomainToDto(departamentoDomain);
	}

	@Override
	public DepartamentoDTO getById(Integer id) {
		final DepartamentoDomain departamentoDomain = departamentoDao.findById(id).get();
		return convertDomainToDto(departamentoDomain);
	}

	@Override
	protected DepartamentoDTO convertDomainToDto(DepartamentoDomain domain) {
		final DepartamentoDTO dto = new DepartamentoDTO();
		dto.setId(domain.getId());
		dto.setPaisId(domain.getPais().getId());
		dto.setNombre(domain.getNombre());
		return dto;
	}

	@Override
	protected DepartamentoDomain convertDtoToDomain(DepartamentoDTO dto) {
		final DepartamentoDomain domain = new DepartamentoDomain();
		domain.setId(dto.getId());
		domain.setPais(paisDao.findById(dto.getPaisId()).get());
		domain.setNombre(dto.getNombre());
		return domain;
	}
	/*
	 
	 @Override
	protected StateDomain convertDtoToDomain(StateDTO dto) {
		final StateDomain domain = new StateDomain();
		domain.setId(dto.getId());
		domain.setCountry(countryDao.findById(dto.getCountryId()).get());
		domain.setName(dto.getName());
		return domain;
	}

	  */
	
	@Override
	public DepartamentoResult getAll(Pageable pageable) {
		final List<DepartamentoDTO> departamentos = new ArrayList<>();
		Page<DepartamentoDomain> resultados = departamentoDao.findAll(pageable);
		resultados.forEach(e -> departamentos.add(convertDomainToDto(e)));
		DepartamentoResult departamentoResult = new DepartamentoResult();
		departamentoResult.setDepartamentos(departamentos);
		return departamentoResult;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DepartamentoDTO update(Integer id, DepartamentoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartamentoResult search(Pageable pageable, String texto) {
		// TODO Auto-generated method stub
		return null;
	}
}