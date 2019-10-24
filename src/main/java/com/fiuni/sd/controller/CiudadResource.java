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

import com.fiuni.sd.dto.ubicacion.ciudad.CiudadDTO;
import com.fiuni.sd.dto.ubicacion.ciudad.CiudadResult;
import com.fiuni.sd.service.ciudad.ICiudadService;
import com.fiuni.sd.utils.Configuracion;

@RestController
@RequestMapping("/ciudades")
public class CiudadResource {
	@Autowired
	private ICiudadService ciudadService;

	@GetMapping("/{id}")
	public CiudadDTO getById(@PathVariable(value = "id") Integer ciudadId) {
		return ciudadService.getById(ciudadId);
	}

	@GetMapping(path = "/page/", params= {"page","size"})
	public CiudadResult getCiudades(@PathVariable(value = "page_num")Integer pageNum) {
		return ciudadService.getAll(PageRequest.of(pageNum, Configuracion.PAGE_SIZE));
	}

	@PostMapping()
	public CiudadDTO save(@Valid @RequestBody CiudadDTO ciudad) {
		return ciudadService.save(ciudad);
	}
}