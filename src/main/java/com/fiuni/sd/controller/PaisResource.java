package com.fiuni.sd.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fiuni.sd.dto.ubicacion.pais.PaisDTO;
import com.fiuni.sd.dto.ubicacion.pais.PaisResult;
import com.fiuni.sd.service.pais.IPaisService;
import com.fiuni.sd.utils.Configuracion;

@RestController
@RequestMapping("/paises")
public class PaisResource {
	@Autowired
	private IPaisService paisService;

	@GetMapping("/{id}")
	public PaisDTO getById(@PathVariable(value = "id") Integer paisId) {
		return paisService.getById(paisId);
	}

	@GetMapping(path = "/pag/{pag_num}")
	public PaisResult getPaises(@PathVariable(value = "pag_num")Integer pagNum) {
		return paisService.getAll(PageRequest.of((pagNum - 1), Configuracion.PAGE_SIZE));
	}

	@GetMapping(params= {"page","size"})
	public PaisResult search(@PathParam("textToFind") String textToFind) {
		return paisService.find(textToFind);
	}

	@PostMapping()
	public PaisDTO save(@Valid @RequestBody PaisDTO pais) {
		return paisService.save(pais);
	}
}