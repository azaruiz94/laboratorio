package com.fiuni.sd.dao.tipo_persona;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.domain.tipo_persona.TipoPersonaDomain;


@Repository
public interface ITipoPersonaDao extends PagingAndSortingRepository<TipoPersonaDomain, Integer>{
	
}