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
import com.fiuni.sd.dto.ubicacion.departamento.DepartamentoDTO;
import com.fiuni.sd.dto.ubicacion.departamento.DepartamentoResult;
import com.fiuni.sd.service.departamento.IDepartamentoService;
import com.fiuni.sd.utils.Configuracion;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoResource {
	
	@Autowired
	Configuracion config;
	
	@Autowired
	private IDepartamentoService departamentoService;

	@GetMapping("/{id}")
	public DepartamentoDTO getById(@PathVariable(value = "id") Integer departamentoId) {
		return departamentoService.getById(departamentoId);
	}

	@GetMapping(path = "/pag/{pag_num}")
	public DepartamentoResult getDepartamentos(@PathVariable(value = "pag_num") Integer pagNum) {
		return departamentoService.getAll(PageRequest.of((pagNum - 1), config.getPageSize()));
	}

	@PostMapping()
	public DepartamentoDTO save(@Valid @RequestBody DepartamentoDTO departamento) {
		return departamentoService.save(departamento);
	}
}