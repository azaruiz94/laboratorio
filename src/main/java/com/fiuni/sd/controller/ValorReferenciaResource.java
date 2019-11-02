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
import com.fiuni.sd.dto.valor_referencia.ValorReferenciaDTO;
import com.fiuni.sd.dto.valor_referencia.ValorReferenciaResult;
import com.fiuni.sd.service.valor_referencia.IValorReferenciaService;
import com.fiuni.sd.utils.Configuracion;

@RestController
@RequestMapping("/valoresReferencia")
public class ValorReferenciaResource {
	
	@Autowired
	Configuracion config;
	
	@Autowired
	private IValorReferenciaService valorReferenciaService;

	@GetMapping("/{id}")
	public ValorReferenciaDTO getById(@PathVariable(value = "id") Integer valorReferenciaId) {
		return valorReferenciaService.getById(valorReferenciaId);
	}

	@GetMapping(path = "/pag/{pag_num}")
	public ValorReferenciaResult getValorReferencia(@PathVariable(value = "pag_num") Integer pagNum) {
		return valorReferenciaService.getAll(PageRequest.of((pagNum - 1), config.getPageSize()));
	}

	@PostMapping()
	public ValorReferenciaDTO save(@Valid @RequestBody ValorReferenciaDTO valorReferencia) {
		return valorReferenciaService.save(valorReferencia);
	}
}
