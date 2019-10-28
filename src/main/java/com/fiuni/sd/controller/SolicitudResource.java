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

import com.fiuni.sd.dto.solicitud.SolicitudDTO;
import com.fiuni.sd.dto.solicitud.SolicitudResult;
import com.fiuni.sd.service.solicitud.ISolicitudService;
import com.fiuni.sd.utils.Configuracion;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudResource {
	
	//buscar por id
	@GetMapping("/{id}")
	public SolicitudDTO getById(@PathVariable(value = "id") Integer solicitudId) {
		return solicitudService.getById(solicitudId);
	}
	
	//Read
	@GetMapping(path = "/pag/{pag_num}")
	public SolicitudResult getSolicitudes(@PathVariable(value = "pag_num")Integer pagNum) {
		return solicitudService.getAll(PageRequest.of((pagNum - 1), Configuracion.PAGE_SIZE));
	}
	
	//create
	@PostMapping()
	public SolicitudDTO save(@Valid @RequestBody SolicitudDTO solicitud) {
		return solicitudService.save(solicitud);
	}
	
	@Autowired
	private ISolicitudService solicitudService;
}