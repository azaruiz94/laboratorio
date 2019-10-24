package com.fiuni.sd.dao.tipo_persona;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.domain.tipo_persona.TipoPersonaDomain;


@Repository
public interface ITipoPersonaDao extends CrudRepository<TipoPersonaDomain, Integer>{
	public Page<TipoPersonaDomain> findAll(Pageable pageable);
}