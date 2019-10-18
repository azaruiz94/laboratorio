package com.fiuni.sd.dao.factura_detalle;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.domain.factura_detalle.FacturaDetalleDomain;

@Repository
public interface IFacturaDetalleDao extends CrudRepository<FacturaDetalleDomain, Integer>{
	public Page<FacturaDetalleDomain> findAll(Pageable pageable);
}