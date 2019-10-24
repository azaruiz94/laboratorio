package com.fiuni.sd.dao.sexo;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.domain.sexo.SexoDomain;

@Repository
public interface ISexoDao extends PagingAndSortingRepository<SexoDomain, Integer>{
	
}