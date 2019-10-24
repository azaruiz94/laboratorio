package com.fiuni.sd.dao.estado;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.domain.estado.EstadoDomain;


@Repository
public interface IEstadoDao extends PagingAndSortingRepository<EstadoDomain, Integer>{
	
}