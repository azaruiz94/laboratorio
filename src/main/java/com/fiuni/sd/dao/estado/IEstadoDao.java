package com.fiuni.sd.dao.estado;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.domain.estado.EstadoDomain;

@Repository
public interface IEstadoDao extends CrudRepository<EstadoDomain, Integer>{
	public Page<EstadoDomain> findAll(Pageable pageable);
}