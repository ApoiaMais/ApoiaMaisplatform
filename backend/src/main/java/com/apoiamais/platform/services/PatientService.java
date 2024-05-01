package com.apoiamais.platform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apoiamais.platform.dtos.PatientDTO;
import com.apoiamais.platform.dtos.PatientMinDTO;
import com.apoiamais.platform.entities.Patient;
import com.apoiamais.platform.repositories.PatientRepository;
import com.apoiamais.platform.services.exceptions.DatabaseException;
import com.apoiamais.platform.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PatientService {

	@Autowired
	private PatientRepository repository;

	@Transactional(readOnly = true)
	public PatientMinDTO findById(Long id) {
		Patient entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado, id inválido"));
		return new PatientMinDTO(entity);
	}

	@Transactional(readOnly = true)
	public Page<PatientMinDTO> findAllPaged(Pageable pageable) {
		Page<Patient> patients = repository.findAll(pageable);
		return patients.map(item -> new PatientMinDTO(item));
	}

	@Transactional
	public PatientDTO insert(PatientDTO dto) {
		Patient entity = new Patient();
		dtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new PatientDTO(entity);
	}

	@Transactional
	public PatientMinDTO update(Long id, PatientMinDTO dto) {
		try {
			Patient entity = repository.getReferenceById(id);
			entity = minDtoToEntity(dto, entity);
			repository.save(entity);
			return new PatientMinDTO(entity);
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

	private Patient dtoToEntity(PatientDTO dto, Patient entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		entity.setBirthDate(dto.getBirthDate());
		entity.setCpf(dto.getCpf());
		entity.setRg(dto.getRg());
		entity.setNis(dto.getNis());
		return entity;
	}

	private Patient minDtoToEntity(PatientMinDTO dto, Patient entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		entity.setBirthDate(dto.getBirthDate());
		entity.setCpf(dto.getCpf());
		entity.setRg(dto.getRg());
		entity.setNis(dto.getNis());
		return entity;
	}
}
