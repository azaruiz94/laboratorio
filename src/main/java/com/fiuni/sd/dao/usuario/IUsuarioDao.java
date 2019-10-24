package com.fiuni.sd.dao.usuario;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.domain.estado.EstadoDomain;


@Repository
public interface IUsuarioDao extends PagingAndSortingRepository<EstadoDomain, Integer>{
	
}