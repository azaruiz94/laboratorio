package com.fiuni.sd.dao.tipo_analisis;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.domain.tipo_analisis.TipoAnalisisDomain;


@Repository
public interface ITipoAnalisisDao extends PagingAndSortingRepository<TipoAnalisisDomain, Integer>{
	@Query(value= "SELECT * FROM tipo_analisis campo WHERE campo.nombre LIKE %?1%", countQuery= "SELECT count (*) FROM tipo_analisis", nativeQuery= true)
	public Page<TipoAnalisisDomain> search(Pageable pageable, String term);
}