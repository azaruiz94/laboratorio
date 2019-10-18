package com.fiuni.sd.dao.persona;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.domain.persona.PersonaDomain;

@Repository
public interface IPersonaDao extends CrudRepository<PersonaDomain, Integer>{
	public Page<PersonaDomain> findAll(Pageable pageable);
}