package com.fiuni.sd.dao.solicitud_detalle;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.domain.solicitud_detalle.SolicitudDetalleDomain;

@Repository
public interface ISolicitudDetalleDao extends PagingAndSortingRepository<SolicitudDetalleDomain, Integer> {

}