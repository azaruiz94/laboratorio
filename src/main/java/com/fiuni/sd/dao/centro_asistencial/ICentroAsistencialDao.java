package com.fiuni.sd.dao.centro_asistencial;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.domain.centro_asistencial.CentroAsistencialDomain;

@Repository
public interface ICentroAsistencialDao extends PagingAndSortingRepository<CentroAsistencialDomain, Integer>{
	
}