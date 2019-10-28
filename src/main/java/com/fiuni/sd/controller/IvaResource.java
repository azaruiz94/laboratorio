package com.fiuni.sd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.dto.iva.IvaDTO;
import com.fiuni.sd.dto.iva.IvaResult;
import com.fiuni.sd.service.iva.IIvaService;
import com.fiuni.sd.utils.Configuracion;

@RestController
@RequestMapping("/ivas")
public class IvaResource {
	
	//buscar por id
	@GetMapping("/{id}")
	public IvaDTO getById(@PathVariable(value = "id") Integer ivaId) {
		return ivaService.getById(ivaId);
	}
	
	//Read
	@GetMapping(path = "/pag/{pag_num}")
	public IvaResult getEstados(@PathVariable(value = "pag_num")Integer pagNum) {
		return ivaService.getAll(PageRequest.of((pagNum - 1), Configuracion.PAGE_SIZE));
	}
	
	
	//create
	@PostMapping()
	public IvaDTO save(@Valid @RequestBody IvaDTO iva) {
		return ivaService.save(iva);
	}
	
	//actualizar
	@PutMapping("/{id}/editar")
	public void updateById(@PathVariable(value = "id") Integer ivaId,@RequestBody IvaDTO dto) {
		ivaService.update(ivaId, dto);
	}
		
	//borrar
	@DeleteMapping("/{id}/borrar")
	public void deleteIvaById(@PathVariable(value = "id") Integer ivaId) {
		ivaService.delete(ivaId);
	}
	
	@Autowired
	private IIvaService ivaService;
}