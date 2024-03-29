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

import com.fiuni.sd.dto.usuario.UsuarioDTO;
import com.fiuni.sd.dto.usuario.UsuarioResult;
import com.fiuni.sd.service.usuario.IUsuarioService;
import com.fiuni.sd.utils.Configuracion;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
	
	//buscar por id
	@GetMapping("/{id}")
	public UsuarioDTO getById(@PathVariable(value = "id") Integer usuarioId) {
		return usuarioService.getById(usuarioId);
	}
	
	//Read
	@GetMapping(path = "/pag/{pag_num}")
	public UsuarioResult getUsuarios(@PathVariable(value = "pag_num")Integer pagNum) {
		return usuarioService.getAll(PageRequest.of((pagNum - 1), config.getPageSize()));
	}
	
	//create
	@PostMapping()
	public UsuarioDTO save(@Valid @RequestBody UsuarioDTO usuario) {
		return usuarioService.save(usuario);
	}
	
	//actualizar
	@PutMapping("/{id}/editar")
	public void updateById(@PathVariable(value = "id") Integer usuarioId,@RequestBody UsuarioDTO dto) {
		usuarioService.update(usuarioId, dto);
	}
	
	//borrar
	@DeleteMapping("/{id}/borrar")
	public void deleteUsuarioById(@PathVariable(value = "id") Integer usuarioId) {
		usuarioService.delete(usuarioId);
	}
	
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	Configuracion config;	
	
}