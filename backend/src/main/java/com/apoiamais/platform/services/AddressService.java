package com.apoiamais.platform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apoiamais.platform.dtos.AddressDTO;
import com.apoiamais.platform.entities.Address;
import com.apoiamais.platform.entities.User;
import com.apoiamais.platform.repositories.AddresstRepository;
import com.apoiamais.platform.repositories.UserRepository;
import com.apoiamais.platform.services.exceptions.DatabaseException;
import com.apoiamais.platform.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AddressService {

	@Autowired
	private AddresstRepository repository;
	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public AddressDTO findById(Long id) {
		Address entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado, id inválido"));
		return new AddressDTO(entity);
	}

	@Transactional(readOnly = true)
	public Page<AddressDTO> findAllPaged(Pageable pageable) {
		Page<Address> address = repository.findAll(pageable);
		return address.map(item -> new AddressDTO(item));
	}

	@Transactional
	public AddressDTO insert(AddressDTO dto) {
		Address entity = new Address();
		dtoToEntity(dto, entity);
		User user = userRepository.getReferenceById(dto.getUserId());
		entity.setUser(user);
		entity = repository.save(entity);
		return new AddressDTO(entity);
	}

	@Transactional
	public AddressDTO update(Long id, AddressDTO dto) {
		try {
			Address entity = repository.getReferenceById(id);
			entity = dtoToEntity(dto, entity);
			repository.save(entity);
			return new AddressDTO(entity);
			
		} catch (EntityNotFoundException erro) {
			throw new ResourceNotFoundException("erro");
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {

		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Este recurso não existe");
		}

		try {

			repository.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Falha de integridade referencial");
		}

	}

	private Address dtoToEntity(AddressDTO dto, Address entity) {
		entity.setId(dto.getId());
		entity.setStreet(dto.getStreet());
		entity.setCity(dto.getCity());
		return entity;
	}
}
