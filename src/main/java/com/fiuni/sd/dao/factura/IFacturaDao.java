package com.fiuni.sd.dao.factura;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.domain.factura.FacturaDomain;

@Repository
public interface IFacturaDao extends CrudRepository<FacturaDomain, Integer>{
	public Page<FacturaDomain> findAll(Pageable pageable);
}