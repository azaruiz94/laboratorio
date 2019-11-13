package com.fiuni.sd.dao.rol;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.fiuni.sd.domain.credenciales.rol.RolDomain;

public interface IRolDao extends PagingAndSortingRepository<RolDomain, Integer> {

}