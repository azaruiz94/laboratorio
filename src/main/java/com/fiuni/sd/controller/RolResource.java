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

import com.fiuni.sd.dto.rol.RolDTO;
import com.fiuni.sd.dto.rol.RolResult;
import com.fiuni.sd.service.rol.IRolService;
import com.fiuni.sd.utils.Configuracion;

@RestController
@RequestMapping("/roles")
public class RolResource {
	//buscar por id
		@GetMapping("/{id}")
		public RolDTO getById(@PathVariable(value = "id") Integer rolId) {
			return rolService.getById(rolId);
		}
		
		//Read
		@GetMapping(path = "/pag/{pag_num}")
		public RolResult getEstados(@PathVariable(value = "pag_num")Integer pagNum) {
			return rolService.getAll(PageRequest.of((pagNum - 1), config.getPageSize()));
		}
		
		
		//create
		@PostMapping()
		public RolDTO save(@Valid @RequestBody RolDTO rolDto) {
			return rolService.save(rolDto);
		}
		
		//actualizar
		@PutMapping("/{id}/editar")
		public void updateById(@PathVariable(value = "id") Integer rolId,@RequestBody RolDTO dto) {
			rolService.update(rolId, dto);
		}
		
		//borrar
		@DeleteMapping("/{id}/borrar")
		public void deleteRolById(@PathVariable(value = "id") Integer rolId) {
			rolService.delete(rolId);
		}
		
		@Autowired
		private IRolService rolService;
		
		@Autowired
		Configuracion config;
}