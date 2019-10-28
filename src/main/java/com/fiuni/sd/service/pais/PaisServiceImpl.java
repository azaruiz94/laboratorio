package com.fiuni.sd.service.pais;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fiuni.sd.dao.ubicacion.pais.IPaisDao;
import com.fiuni.sd.domain.ubicacion.pais.PaisDomain;
import com.fiuni.sd.dto.ubicacion.pais.PaisDTO;
import com.fiuni.sd.dto.ubicacion.pais.PaisResult;
import com.fiuni.sd.service.base.BaseServiceImpl;

@Service
public class PaisServiceImpl extends BaseServiceImpl<PaisDTO, PaisDomain, PaisResult> implements IPaisService {
	@Autowired
	private IPaisDao paisDao;

	@Override
	@Transactional
	public PaisDTO save(PaisDTO dto) {
		final PaisDomain domain = convertDtoToDomain(dto);
		final PaisDomain paisDomain = paisDao.save(domain);
		return convertDomainToDto(paisDomain);
	}

	@Override
	@Transactional
	public PaisDTO getById(Integer id) {
		final PaisDomain domain = paisDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	@Transactional
	public PaisResult find(String textToFind) {
		final List<PaisDTO> paises = new ArrayList<>();
		final PaisResult paisResult = new PaisResult();
		paisResult.setPaises(paises);
		return paisResult;
	}

	@Override
	protected PaisDTO convertDomainToDto(PaisDomain domain) {
		final PaisDTO dto = new PaisDTO();
		dto.setId(domain.getId());
		dto.setNombre(domain.getNombre());
		return dto;
	}

	@Override
	protected PaisDomain convertDtoToDomain(PaisDTO dto) {
		final PaisDomain domain = new PaisDomain();
		domain.setId(dto.getId());
		domain.setNombre(dto.getNombre());
		return domain;
	}

	@Override
	public PaisResult getAll(Pageable pageable) {
		final List<PaisDTO> paises = new ArrayList<>();
		Page<PaisDomain> resultados = paisDao.findAll(pageable);
		resultados.forEach(e -> paises.add(convertDomainToDto(e)));
		PaisResult paisResult = new PaisResult();
		paisResult.setPaises(paises);
		return paisResult;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaisDTO update(Integer id, PaisDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
}