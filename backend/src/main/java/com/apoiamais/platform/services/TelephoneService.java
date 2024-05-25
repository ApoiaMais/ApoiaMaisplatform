package com.apoiamais.platform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apoiamais.platform.dtos.TelephoneDTO;
import com.apoiamais.platform.entities.Telephone;
import com.apoiamais.platform.entities.User;
import com.apoiamais.platform.repositories.TelephoneRepository;
import com.apoiamais.platform.repositories.UserRepository;
import com.apoiamais.platform.services.exceptions.DatabaseException;
import com.apoiamais.platform.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TelephoneService {

	@Autowired
	private TelephoneRepository telephoneRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public Page<TelephoneDTO> findAllPaged(Pageable pageable) {
		Page<Telephone> telephone = telephoneRepository.findAll(pageable);
		return telephone.map(obj -> new TelephoneDTO(obj));
	}

	@Transactional(readOnly = true)
	public TelephoneDTO findById(Long id) {
		Telephone telephone = telephoneRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("id não encontrado."));
		return new TelephoneDTO(telephone);
	}

	@Transactional
	public TelephoneDTO insert(TelephoneDTO dto) {
		Telephone entity = new Telephone();
		entity = dtoToEntity(dto, entity);
		User user = userRepository.getReferenceById(dto.getUserId());
		entity.setUser(user);
		entity = telephoneRepository.save(entity);
		return new TelephoneDTO(entity);
	}

	@Transactional
	public TelephoneDTO update(Long id, TelephoneDTO dto) {
		try {
			Telephone entity = telephoneRepository.getReferenceById(id);
			entity = dtoToEntity(dto, entity);
			telephoneRepository.save(entity);
			return new TelephoneDTO(entity);
		} catch (EntityNotFoundException erro) {
			throw new ResourceNotFoundException("erro");
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {

		if (!telephoneRepository.existsById(id)) {
			throw new ResourceNotFoundException("Este recurso não existe");
		}
		try {

			telephoneRepository.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Falha de integridade referencial");
		}
	}

	private Telephone dtoToEntity(TelephoneDTO dto, Telephone entity) {
		entity.setId((dto).getId());
		entity.setDdd((dto).getDdd());
		entity.setNumber(dto.getNumber());
		return entity;
	}
}
