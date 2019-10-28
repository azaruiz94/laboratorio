package com.fiuni.sd.dao.solicitud;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.domain.solicitud.SolicitudDomain;

@Repository
public interface ISolicitudDao extends PagingAndSortingRepository<SolicitudDomain, Integer> {

}