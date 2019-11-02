package com.fiuni.sd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.dto.persona.PersonaDTO;
import com.fiuni.sd.dto.persona.PersonaResult;
import com.fiuni.sd.service.persona.IPersonaService;
import com.fiuni.sd.utils.Configuracion;

@RestController
@RequestMapping("/personas")
public class PersonaResource {
	
	//buscar por id
	@GetMapping("/{id}")
	public PersonaDTO getById(@PathVariable(value = "id") Integer personaId) {
		return personaService.getById(personaId);
	}
	
	//Read
	@GetMapping(path = "/pag/{pag_num}")
	public PersonaResult getPersonas(@PathVariable(value = "pag_num")Integer pagNum) {
		return personaService.getAll(PageRequest.of((pagNum - 1), config.getPageSize()));
	}
	
	
	//create
	@PostMapping()
	public PersonaDTO save(@Valid @RequestBody PersonaDTO dto) {
		return personaService.save(dto);
	}
	

	//actualizar
	@PutMapping("/{id}/editar")
	public void updateById(@PathVariable(value = "id") Integer personaId,@RequestBody PersonaDTO dto) {
		personaService.update(personaId, dto);
	}
	
	//borrar
	@DeleteMapping("/{id}/borrar")
	public void deletePersonaById(@PathVariable(value = "id") Integer personaId) {
		personaService.delete(personaId);
	}
	
	
	@Autowired
	private IPersonaService personaService;
	
	@Autowired
	Configuracion config;
}