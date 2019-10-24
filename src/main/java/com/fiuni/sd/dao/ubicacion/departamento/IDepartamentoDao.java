package com.fiuni.sd.dao.ubicacion.departamento;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.fiuni.sd.domain.ubicacion.departamento.DepartamentoDomain;

@Repository
public interface IDepartamentoDao extends PagingAndSortingRepository<DepartamentoDomain, Integer> {

}