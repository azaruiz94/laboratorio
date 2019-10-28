package com.fiuni.sd.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.dto.tipo_analisis.TipoAnalisisDTO;
import com.fiuni.sd.dto.tipo_analisis.TipoAnalisisResult;
import com.fiuni.sd.exceptions.tipo_analisis.TipoAnalisisNotFoundException;
import com.fiuni.sd.service.tipo_analisis.ITipoAnalisisService;
import com.fiuni.sd.utils.Configuracion;

@RestController
@RequestMapping("/tipos-analisis")
public class TipoAnalisisResource {
	
	//buscar por id
	@GetMapping("/{id}")
	public TipoAnalisisDTO getById(@PathVariable(value = "id") Integer tipoAnalisisId) {
		Optional<TipoAnalisisDTO> resultado= Optional.ofNullable(tipoAnalisisService.getById(tipoAnalisisId));
		if(resultado.get().equals(null)) {
			System.out.println("entrado en if...");
			return resultado.get();
		}else {
			return resultado.orElseThrow(() -> new TipoAnalisisNotFoundException(tipoAnalisisId));
		}
	}
	
	//Read
	@GetMapping(path = "/pag/{pag_num}")
	public TipoAnalisisResult getEstados(@PathVariable(value = "pag_num")Integer pagNum) {
		return tipoAnalisisService.getAll(PageRequest.of((pagNum - 1), Configuracion.PAGE_SIZE));
	}
	
	//create
	@PostMapping()
	public TipoAnalisisDTO save(@Valid @RequestBody TipoAnalisisDTO tipoAnalisis) {
		return tipoAnalisisService.save(tipoAnalisis);
	}
	
	@Autowired
	private ITipoAnalisisService tipoAnalisisService;
}