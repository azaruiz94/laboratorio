package com.fiuni.sd.service.persona;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.dao.persona.IPersonaDao;
import com.fiuni.sd.domain.persona.PersonaDomain;
import com.fiuni.sd.dto.persona.PersonaDTO;
import com.fiuni.sd.dto.persona.PersonaResult;
import com.fiuni.sd.service.base.BaseServiceImpl;
import com.fiuni.sd.utils.Configuracion;


@Service
public class PersonaServiceImpl extends BaseServiceImpl<PersonaDTO, PersonaDomain, PersonaResult> implements IPersonaService {

	@Override
	@Transactional
	public PersonaDTO save(PersonaDTO dto) {
		final PersonaDomain domain = convertDtoToDomain(dto);
		final PersonaDomain personaDomain = personaDao.save(domain);
		PersonaDTO personaDto = convertDomainToDto(personaDomain);
		if(null == personaDto.getId()) {
			cacheManager.getCache(config.getCacheName()).put(formatCacheKey("personaDomain", personaDto.getId()), personaDto);
		}
		
		return personaDto;
	}

	@Override
	@Transactional
	@Cacheable(value = "api_laboratorio_cache", key = "'api_PersonaDomain' + #id")
	public PersonaDTO getById(Integer id) {
		final PersonaDomain domain = personaDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	public PersonaResult getAll(Pageable pageable) {
		final List<PersonaDTO> personas = new ArrayList<>();
		Page<PersonaDomain> resultados = personaDao.findAll(pageable);
		resultados.forEach(e -> {
			PersonaDTO personaDto = convertDomainToDto(e);
			personas.add(personaDto);
			cacheManager.getCache(config.getCacheName()).put(formatCacheKey("personaDomain", personaDto.getId()), personaDto);
		});
		PersonaResult personaResult = new PersonaResult();
		personaResult.setPersonas(personas);
		return personaResult;
	}
	
	
	@Override
	public void delete(Integer id) {
		personaDao.deleteById(id);
	}

	@Override
	public PersonaDTO update(Integer id, PersonaDTO dto) {
		PersonaDomain domain = personaDao.findById(id).get();
		
		domain.setId(dto.getId());	
		domain.setNombre(dto.getNombre());
		domain.setCiudad(dto.getCiudadId());		
		domain.setDireccion(dto.getDireccion());
		domain.setEmail(dto.getEmail());		
		domain.setNumero_registro(dto.getNumero_registro());
	  domain.setRuc_ci(dto.getRuc_ci());
		domain.setSexo(dto.getSexoId());
		domain.setTelefono(dto.getTelefono());
		domain.setTipoPersona(dto.getTipoPersonaId());

		PersonaDomain personaActualizada = personaDao.save(domain);
		return convertDomainToDto(personaActualizada);
	}
  
  @Override
	public PersonaResult search(Pageable pageable, String texto) {
		// TODO Auto-generated method stub
		return null;
	}
  
	public String formatCacheKey(String domain, Integer id) {
		String base = "api_";
		return base + domain + "_" + id;
	}
	
	@Override
	protected PersonaDTO convertDomainToDto(PersonaDomain domain) {
		final PersonaDTO dto = new PersonaDTO();
		
		dto.setId(domain.getId());
		dto.setNombre(domain.getNombre());
		dto.setCiudadId(domain.getCiudadId());
		dto.setNumero_registro(domain.getNumero_registro());
		dto.setRuc_ci(domain.getRuc_ci());
		dto.setSexoId(domain.getSexo());
 		dto.setTipoPersonaId(domain.getTipoPersona());
 		dto.setDireccion(domain.getDireccion());
 		dto.setEmail(domain.getEmail());
 		dto.setTelefono(domain.getTelefono());
 		return dto;
	}

	@Override
	protected PersonaDomain convertDtoToDomain(PersonaDTO dto) {
		final PersonaDomain domain = new PersonaDomain();
		
		domain.setId(dto.getId());		
		domain.setNombre(dto.getNombre());
		domain.setCiudad(dto.getCiudadId());
		domain.setDireccion(dto.getDireccion());
		domain.setEmail(dto.getEmail());
		domain.setNumero_registro(dto.getNumero_registro());
		domain.setRuc_ci(dto.getRuc_ci());
		domain.setSexo(dto.getSexoId());
		domain.setTelefono(dto.getTelefono());
		domain.setTipoPersona(dto.getTipoPersonaId());

		return domain;
	}

	@Autowired
	private IPersonaDao personaDao;	
	
	@Autowired
	CacheManager cacheManager;
	
	@Autowired
	Configuracion config;
}
