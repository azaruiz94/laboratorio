package com.fiuni.sd.dao.ubicacion.pais;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.fiuni.sd.domain.ubicacion.pais.PaisDomain;

@Repository
public interface IPaisDao extends PagingAndSortingRepository<PaisDomain, Integer> {

}