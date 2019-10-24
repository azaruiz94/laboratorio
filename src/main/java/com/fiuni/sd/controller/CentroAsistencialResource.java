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

import com.fiuni.sd.dto.centro_asistencial.CentroAsistencialDTO;
import com.fiuni.sd.dto.centro_asistencial.CentroAsistencialResult;
import com.fiuni.sd.service.centro_asistencial.ICentroAsistencialService;
import com.fiuni.sd.utils.Configuracion;

@RestController
@RequestMapping("/centros_asistenciales")
public class CentroAsistencialResource {
	
	//buscar por id
	@GetMapping("/{id}")
	public CentroAsistencialDTO getById(@PathVariable(value = "id") Integer centroAsistencialId) {
		return centroAsistencialService.getById(centroAsistencialId);
	}
	
	//Read
	@GetMapping(path = "/pag/{pag_num}")
	public CentroAsistencialResult getEstados(@PathVariable(value = "pag_num")Integer pagNum) {
		return centroAsistencialService.getAll(PageRequest.of((pagNum - 1), Configuracion.PAGE_SIZE));
	}
	
	//create
	@PostMapping()
	public CentroAsistencialDTO save(@Valid @RequestBody CentroAsistencialDTO centroAsistencial) {
		return centroAsistencialService.save(centroAsistencial);
	}
	
	@Autowired
	private ICentroAsistencialService centroAsistencialService;
}