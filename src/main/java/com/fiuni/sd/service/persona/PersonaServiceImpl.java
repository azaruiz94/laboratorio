package com.fiuni.sd.service.persona;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.dao.persona.IPersonaDao;
import com.fiuni.sd.dao.sexo.ISexoDao;
import com.fiuni.sd.dao.tipo_persona.ITipoPersonaDao;
import com.fiuni.sd.dao.ubicacion.ciudad.ICiudadDao;
import com.fiuni.sd.domain.persona.PersonaDomain;
import com.fiuni.sd.dto.persona.PersonaDTO;
import com.fiuni.sd.dto.persona.PersonaResult;
import com.fiuni.sd.service.base.BaseServiceImpl;


@Service
public class PersonaServiceImpl extends BaseServiceImpl<PersonaDTO, PersonaDomain, PersonaResult> implements IPersonaService {

	@Override
	@Transactional
	public PersonaDTO save(PersonaDTO dto) {
		final PersonaDomain domain = convertDtoToDomain(dto);
		final PersonaDomain personaDomain = personaDao.save(domain);
		return convertDomainToDto(personaDomain);
	}

	@Override
	@Transactional
	public PersonaDTO getById(Integer id) {
		final PersonaDomain domain = personaDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	public PersonaResult getAll(Pageable pageable) {
		final List<PersonaDTO> personas = new ArrayList<>();
		Page<PersonaDomain> resultados = personaDao.findAll(pageable);
		resultados.forEach(e -> personas.add(convertDomainToDto(e)));
		
		PersonaResult personaResult = new PersonaResult();
		personaResult.setPersonas(personas);
		return personaResult;
	}
	
	@Override
	public PersonaDTO delete(PersonaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected PersonaDTO convertDomainToDto(PersonaDomain domain) {
		final PersonaDTO dto = new PersonaDTO();
		dto.setId(domain.getId());
		dto.setCiudadDTOId(domain.getCiudadId().getId());
		dto.setNumero_registro(domain.getNumero_registro());
		dto.setRuc_ci(domain.getRuc_ci());
		dto.setNombre(domain.getNombre());
		dto.setSexoDTOId(domain.getSexo().get_id());
		dto.setTipoPersonaDTOId(domain.getTipoPersona().get_id());
		return dto;
	}

	@Override
	protected PersonaDomain convertDtoToDomain(PersonaDTO dto) {
		final PersonaDomain domain = new PersonaDomain();
		domain.setId(dto.getId());
		domain.setCiudad(ciudadDao.findById(dto.getId()).get());
		domain.setNumero_registro(dto.getNumero_registro());
		domain.setRuc_ci(dto.getRuc_ci());
		domain.setNombre(dto.getNombre());
		domain.setSexo(sexoDao.findById(dto.getId()).get());
		domain.setTipoPersona(tipoPersonaDao.findById(dto.getId()).get());
		domain.setDireccion(personaDao.findById(dto.getId()).get().getDireccion());
		domain.setEmail(personaDao.findById(dto.getId()).get().getEmail());
		domain.setTelefono(personaDao.findById(dto.getId()).get().getTelefono());
		return domain;
	}

	@Autowired
	private IPersonaDao personaDao;
	private ICiudadDao ciudadDao;
	private ISexoDao sexoDao;
	private ITipoPersonaDao tipoPersonaDao;
	
}
