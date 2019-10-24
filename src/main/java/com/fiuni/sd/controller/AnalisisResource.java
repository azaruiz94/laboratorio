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

import com.fiuni.sd.dto.analisis.AnalisisDTO;
import com.fiuni.sd.dto.analisis.AnalisisResult;
import com.fiuni.sd.service.analisis.IAnalisisService;
import com.fiuni.sd.utils.Configuracion;

@RestController
@RequestMapping("/analisis")
public class AnalisisResource {
	
	//buscar por id
	@GetMapping("/{id}")
	public AnalisisDTO getById(@PathVariable(value = "id") Integer analisisId) {
		return analisisService.getById(analisisId);
	}
	
	//Read
	@GetMapping(path = "/pag/{pag_num}")
	public AnalisisResult getEstados(@PathVariable(value = "pag_num")Integer pagNum) {
		return analisisService.getAll(PageRequest.of((pagNum - 1), Configuracion.PAGE_SIZE));
	}
	
	//create
	@PostMapping()
	public AnalisisDTO save(@Valid @RequestBody AnalisisDTO analisis) {
		return analisisService.save(analisis);
	}
	
	@Autowired
	private IAnalisisService analisisService;
}