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

import com.fiuni.sd.dto.tipo_persona.TipoPersonaDTO;
import com.fiuni.sd.dto.tipo_persona.TipoPersonaResult;
import com.fiuni.sd.service.tipo_persona.ITipoPersonaService;
import com.fiuni.sd.utils.Configuracion;


@RestController
@RequestMapping("/tipoPersonas")
public class TipoPersonaResource {
	
	//buscar por id
	@GetMapping("/{id}")
	public TipoPersonaDTO getById(@PathVariable(value = "id") Integer tipoPersonaId) {
		return tipoPersonaService.getById(tipoPersonaId);
	}
	
	//Read
	@GetMapping(path = "/pag/{pag_num}")
	public TipoPersonaResult getSexos(@PathVariable(value = "pag_num")Integer pagNum) {
		return tipoPersonaService.getAll(PageRequest.of((pagNum - 1), Configuracion.PAGE_SIZE));
	}
	
	
	//create
	@PostMapping()
	public TipoPersonaDTO save(@Valid @RequestBody TipoPersonaDTO tipoPersona) {
		return tipoPersonaService.save(tipoPersona);
	}
	

	//actualizar
	@PutMapping("/{id}/editar")
	public void updateById(@PathVariable(value = "id") Integer tipoPersonaId,@RequestBody TipoPersonaDTO dto) {
		tipoPersonaService.update(tipoPersonaId, dto);
	}
	
	//borrar
	@DeleteMapping("/{id}/borrar")
	public void deleteTipoPersonaById(@PathVariable(value = "id") Integer tipoPersonaId) {
		tipoPersonaService.delete(tipoPersonaId);
	}
	
	@Autowired
	private ITipoPersonaService tipoPersonaService;
}