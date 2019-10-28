package com.fiuni.sd.service.iva;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.dao.iva.IIvaDao;
import com.fiuni.sd.domain.iva.IvaDomain;
import com.fiuni.sd.dto.iva.IvaDTO;
import com.fiuni.sd.dto.iva.IvaResult;
import com.fiuni.sd.service.base.BaseServiceImpl;


@Service
public class IvaServiceImpl extends BaseServiceImpl<IvaDTO, IvaDomain, IvaResult> implements IIvaService {

	@Override
	@Transactional
	public IvaDTO save(IvaDTO dto) {
		final IvaDomain domain = convertDtoToDomain(dto);
		final IvaDomain ivaDomain = ivaDao.save(domain);
		return convertDomainToDto(ivaDomain);
	}

	@Override
	@Transactional
	public IvaDTO getById(Integer id) {
		final IvaDomain domain = ivaDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	public IvaResult getAll(Pageable pageable) {
		final List<IvaDTO> ivas = new ArrayList<>();
		Page<IvaDomain> resultados = ivaDao.findAll(pageable);
		resultados.forEach(e -> ivas.add(convertDomainToDto(e)));
		
		IvaResult ivaResult = new IvaResult();
		ivaResult.setIvas(ivas);
		return ivaResult;
	}
	
	@Override
	public void delete(Integer id) {
		ivaDao.deleteById(id);
	}
	
	public IvaDTO update(Integer id, IvaDTO dto) {
		IvaDomain domain = ivaDao.findById(id).get();
		domain.set_id(dto.getId());
		domain.setValor(dto.getValor());
		IvaDomain ivaActualizado = ivaDao.save(domain);
		return convertDomainToDto(ivaActualizado);
	}
	
	@Override
	protected IvaDTO convertDomainToDto(IvaDomain domain) {
		final IvaDTO dto = new IvaDTO();
		dto.setId(domain.get_id());
		dto.setValor(domain.getValor());
		return dto;
	}

	@Override
	protected IvaDomain convertDtoToDomain(IvaDTO dto) {
		final IvaDomain domain = new IvaDomain();
		domain.set_id(dto.getId());
		domain.setValor(dto.getValor());
		return domain;
	}

	@Autowired
	private IIvaDao ivaDao;
	
}
