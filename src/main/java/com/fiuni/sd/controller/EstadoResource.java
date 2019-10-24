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

import com.fiuni.sd.dto.estado.EstadoDTO;
import com.fiuni.sd.dto.estado.EstadoResult;
import com.fiuni.sd.service.estado.IEstadoService;
import com.fiuni.sd.utils.Configuracion;

@RestController
@RequestMapping("/estados")
public class EstadoResource {
	
	//buscar por id
	@GetMapping("/{id}")
	public EstadoDTO getById(@PathVariable(value = "id") Integer estadoId) {
		return estadoService.getById(estadoId);
	}
	
	//Read
	@GetMapping(path = "/pag/{pag_num}")
	public EstadoResult getEstados(@PathVariable(value = "pag_num")Integer pagNum) {
		return estadoService.getAll(PageRequest.of((pagNum - 1), Configuracion.PAGE_SIZE));
	}
	
	
	//create
	@PostMapping()
	public EstadoDTO save(@Valid @RequestBody EstadoDTO estado) {
		return estadoService.save(estado);
	}
	
	@Autowired
	private IEstadoService estadoService;
}