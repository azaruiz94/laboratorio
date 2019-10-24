package com.fiuni.sd.dao.valor_referencia;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.fiuni.sd.domain.valor_referencia.ValorReferenciaDomain;

@Repository
public interface IValorReferenciaDao extends PagingAndSortingRepository<ValorReferenciaDomain, Integer> {

}