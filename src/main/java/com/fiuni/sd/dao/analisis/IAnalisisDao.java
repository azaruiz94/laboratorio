package com.fiuni.sd.dao.analisis;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.domain.analisis.AnalisisDomain;

@Repository
public interface IAnalisisDao extends PagingAndSortingRepository<AnalisisDomain, Integer>{
	
}