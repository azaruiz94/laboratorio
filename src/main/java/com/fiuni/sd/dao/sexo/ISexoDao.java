package com.fiuni.sd.dao.sexo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.domain.sexo.SexoDomain;

@Repository
public interface ISexoDao extends CrudRepository<SexoDomain, Integer>{
	public Page<SexoDomain> findAll(Pageable pageable);
}