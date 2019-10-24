package com.fiuni.sd.dao.tipo_analisis;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.domain.tipo_analisis.TipoAnalisisDomain;


@Repository
public interface ITipoAnalisisDao extends PagingAndSortingRepository<TipoAnalisisDomain, Integer>{
	
}