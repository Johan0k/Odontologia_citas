package ec.webmarket.restful.service.crud;


import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.webmarket.restful.domain.Odontologo;

import ec.webmarket.restful.dto.v1.OdontologoDTO;

import ec.webmarket.restful.persistence.OdontologoRepository;

import ec.webmarket.restful.service.GenericCrudServiceImpl;

@Service
public class OdontologoService extends GenericCrudServiceImpl<Odontologo, OdontologoDTO>{

	 @Autowired
	private OdontologoRepository  repository;
	 
	 

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Odontologo> find(OdontologoDTO dto) {
		return repository.findById(dto.getId());
	}
	
	@Override
	public Odontologo mapToDomain(OdontologoDTO dto) {
		return modelMapper.map(dto, Odontologo.class);
	}
	
	
	@Override
	public OdontologoDTO mapToDto(Odontologo domain) {
		return modelMapper.map(domain, OdontologoDTO.class);
	}

	
	
	
}
