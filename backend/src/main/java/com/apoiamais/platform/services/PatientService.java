package com.apoiamais.platform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apoiamais.platform.dtos.PatientDTO;
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
	public PatientDTO findById(Long id) {
		Patient entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado, id inválido"));
		return new PatientDTO(entity);
	}

	@Transactional(readOnly = true)
	public Page<PatientDTO> findAllPaged(Pageable pageable) {
		Page<Patient> patients = repository.findAll(pageable);
		return patients.map(item -> new PatientDTO(item));
	}

	@Transactional
	public PatientDTO insert(PatientDTO dto) {
		Patient entity = new Patient();
		dtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new PatientDTO(entity);
	}

	@Transactional
	public PatientDTO update(Long id, PatientDTO dto) {
		try {
			Patient entity = repository.getReferenceById(id);
			entity = dtoToEntity(dto, entity);
			repository.save(entity);
			return new PatientDTO(entity);
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
		entity.setName(dto.getEmail());
		entity.setEmail(dto.getEmail());
		entity.setCpf(dto.getCpf());
		entity.setBirthDate(dto.getBirthDate());
		entity.setUriPhoto(dto.getUriPhoto());
		entity.setNis(dto.getNis());
		entity.setPassword("123456789101213");
		return entity;
	}

	/*private Patient minDtoToEntity(PatientMinDTO dto, Patient entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setBirthDate(dto.getBirthDate());
		entity.setCpf(dto.getCpf());
		entity.setNis(dto.getNis());
		return entity;
	}*/
}
