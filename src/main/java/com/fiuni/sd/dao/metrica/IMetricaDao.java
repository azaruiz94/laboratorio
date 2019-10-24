package com.fiuni.sd.dao.metrica;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.domain.metrica.MetricaDomain;

@Repository
public interface IMetricaDao extends PagingAndSortingRepository<MetricaDomain, Integer>{
	
}