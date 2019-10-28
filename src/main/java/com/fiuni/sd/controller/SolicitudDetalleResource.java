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

import com.fiuni.sd.dto.solicitud_detalle.SolicitudDetalleDTO;
import com.fiuni.sd.dto.solicitud_detalle.SolicitudDetalleResult;
import com.fiuni.sd.service.solicitud_detalle.ISolicitudDetalleService;
import com.fiuni.sd.utils.Configuracion;

@RestController
@RequestMapping("/solicitud-detalles")
public class SolicitudDetalleResource {
	
	//buscar por id
	@GetMapping("/{id}")
	public SolicitudDetalleDTO getById(@PathVariable(value = "id") Integer solicitudDetalleId) {
		return solicitudDetalleService.getById(solicitudDetalleId);
	}
	
	//Read
	@GetMapping(path = "/pag/{pag_num}")
	public SolicitudDetalleResult getSolicitudes(@PathVariable(value = "pag_num")Integer pagNum) {
		return solicitudDetalleService.getAll(PageRequest.of((pagNum - 1), Configuracion.PAGE_SIZE));
	}
	
	//create
	@PostMapping()
	public SolicitudDetalleDTO save(@Valid @RequestBody SolicitudDetalleDTO solicitud) {
		return solicitudDetalleService.save(solicitud);
	}
	
	@Autowired
	private ISolicitudDetalleService solicitudDetalleService;
}