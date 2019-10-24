package com.fiuni.sd.dao.ubicacion.ciudad;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.fiuni.sd.domain.ubicacion.ciudad.CiudadDomain;

@Repository
public interface ICiudadDao extends PagingAndSortingRepository<CiudadDomain, Integer> {

}