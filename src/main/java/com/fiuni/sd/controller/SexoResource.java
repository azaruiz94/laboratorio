package com.fiuni.sd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.dto.sexo.SexoDTO;
import com.fiuni.sd.dto.sexo.SexoResult;
import com.fiuni.sd.service.sexo.ISexoService;
import com.fiuni.sd.utils.Configuracion;


@RestController
@RequestMapping("/sexos")
public class SexoResource {
	
	//buscar por id
	@GetMapping("/{id}")
	public SexoDTO getById(@PathVariable(value = "id") Integer sexoId) {
		return sexoService.getById(sexoId);
	}
	
	//Read
	@GetMapping(path = "/pag/{pag_num}")
	public SexoResult getSexos(@PathVariable(value = "pag_num")Integer pagNum) {
		return sexoService.getAll(PageRequest.of((pagNum - 1), Configuracion.PAGE_SIZE));
	}
	
	
	//create
	@PostMapping()
	public SexoDTO save(@Valid @RequestBody SexoDTO sexo) {
		return sexoService.save(sexo);
	}
	
	@Autowired
	private ISexoService sexoService;
}