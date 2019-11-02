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

import com.fiuni.sd.dto.metrica.MetricaDTO;
import com.fiuni.sd.dto.metrica.MetricaResult;
import com.fiuni.sd.service.metrica.IMetricaService;
import com.fiuni.sd.utils.Configuracion;

@RestController
@RequestMapping("/metricas")
public class MetricaResource {
	
	//buscar por id
	@GetMapping("/{id}")
	public MetricaDTO getById(@PathVariable(value = "id") Integer metricaId) {
		return tipoAnalisisService.getById(metricaId);
	}
	
	//Read
	@GetMapping(path = "/pag/{pag_num}")
	public MetricaResult getEstados(@PathVariable(value = "pag_num")Integer pagNum) {
		return tipoAnalisisService.getAll(PageRequest.of((pagNum - 1), config.getPageSize()));
	}
	
	//create
	@PostMapping()
	public MetricaDTO save(@Valid @RequestBody MetricaDTO metrica) {
		return tipoAnalisisService.save(metrica);
	}
	
	@Autowired
	private IMetricaService tipoAnalisisService;
	
	@Autowired
	Configuracion config;
}