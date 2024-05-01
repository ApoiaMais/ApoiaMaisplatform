package com.apoiamais.platform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apoiamais.platform.dtos.TherapistDTO;
import com.apoiamais.platform.dtos.TherapistMinDTO;
import com.apoiamais.platform.entities.Therapist;
import com.apoiamais.platform.repositories.TherapistRepository;
import com.apoiamais.platform.services.exceptions.DatabaseException;
import com.apoiamais.platform.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TherapistService {

	@Autowired
	private TherapistRepository repository;

	@Transactional(readOnly = true)
	public TherapistMinDTO findById(Long id) {
		Therapist entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado, id inválido"));
		return new TherapistMinDTO(entity);
	}

	@Transactional(readOnly = true)
	public Page<TherapistMinDTO> findAllPaged(Pageable pageable) {
		Page<Therapist> patients = repository.findAll(pageable);
		return patients.map(item -> new TherapistMinDTO(item));
	}

	@Transactional
	public TherapistDTO insert(TherapistDTO dto) {
		Therapist entity = new Therapist();
		dtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new TherapistDTO(entity);
	}

	@Transactional
	public TherapistMinDTO update(Long id, TherapistMinDTO dto) {
		try {
			Therapist entity = repository.getReferenceById(id);
			entity = minDtoToEntity(dto, entity);
			repository.save(entity);
			return new TherapistMinDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id inválido, Recurso não encontrado");

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

	private Therapist dtoToEntity(TherapistDTO dto, Therapist entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		entity.setCpf(dto.getCpf());
		entity.setUriPhoto(dto.getUriPhoto());
		entity.setLicense(dto.getLicense());
		return entity;
	}

	private Therapist minDtoToEntity(TherapistMinDTO dto, Therapist entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		entity.setCpf(dto.getCpf());
		entity.setUriPhoto(dto.getUriPhoto());
		entity.setLicense(dto.getLicense());
		return entity;
	}
}
