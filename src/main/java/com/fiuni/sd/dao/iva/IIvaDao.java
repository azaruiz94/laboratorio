package com.fiuni.sd.dao.iva;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.domain.iva.IvaDomain;

@Repository
public interface IIvaDao extends PagingAndSortingRepository<IvaDomain, Integer>{
	
}