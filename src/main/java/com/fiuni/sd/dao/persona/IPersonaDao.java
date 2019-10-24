package com.fiuni.sd.dao.persona;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.domain.persona.PersonaDomain;

@Repository
public interface IPersonaDao extends PagingAndSortingRepository<PersonaDomain, Integer>{

}