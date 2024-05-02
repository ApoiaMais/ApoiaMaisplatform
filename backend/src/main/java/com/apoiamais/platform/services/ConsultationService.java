package com.apoiamais.platform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apoiamais.platform.dtos.ConsultationDTO;
import com.apoiamais.platform.entities.Consultation;
import com.apoiamais.platform.repositories.ConsultationRepository;
import com.apoiamais.platform.services.exceptions.DatabaseException;
import com.apoiamais.platform.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ConsultationService {

	@Autowired
	private ConsultationRepository repository;

	@Transactional(readOnly = true)
	public ConsultationDTO findById(Long id) {
		Consultation entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado, id inválido"));
		return new ConsultationDTO(entity);
	}

	@Transactional(readOnly = true)
	public Page<ConsultationDTO> findAllPaged(Pageable pageable) {
		Page<Consultation> consultation = repository.findAll(pageable);
		return consultation.map(item -> new ConsultationDTO(item));
	}

	@Transactional
	public ConsultationDTO insert(ConsultationDTO dto) {
		Consultation entity = new Consultation();
		dtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ConsultationDTO(entity);
	}

	@Transactional
	public ConsultationDTO update(Long id, ConsultationDTO dto) {
		try {
			Consultation entity = repository.getReferenceById(id);
			entity = dtoToEntity(dto, entity);
			repository.save(entity);
			return new ConsultationDTO(entity);
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

	private Consultation dtoToEntity(ConsultationDTO dto, Consultation entity) {
		entity.setId(dto.getId());
		entity.setDate(dto.getDate());
		entity.setDuration(dto.getDuration());
		entity.setPrice(dto.getPrice());
		entity.setStatus(dto.getStatus());
		;
		return entity;
	}
}
