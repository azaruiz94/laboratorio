package com.fiuni.sd.service.base;

import com.fiuni.sd.dto.base.BaseResult;

import java.awt.print.Pageable;

import com.fiuni.sd.dto.base.BaseDTO;

public interface IBaseService <DTO extends BaseDTO, R extends BaseResult<DTO>>{
	public DTO save(DTO dto);

	public DTO getById(Integer id);
	
	public R getAll(Pageable pageable);
}
