package com.fiuni.sd.service.base;

import com.fiuni.sd.dto.base.BaseResult;

import org.springframework.data.domain.Pageable;

import com.fiuni.sd.dto.base.BaseDTO;

public interface IBaseService <DTO extends BaseDTO, R extends BaseResult<DTO>>{
	
	public void delete(Integer id); //borrar
	
	public DTO save(DTO dto); //crear

	public DTO getById(Integer id); //listar
	
	public R getAll(Pageable pageable); //listar
	
	public R search(Pageable pageable, String texto); //buscar
	
	public DTO update(Integer id, DTO dto); //actualizar
	
	public String formatCacheKey(String domain, Integer id);
}
