package com.apoiamais.platform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apoiamais.platform.dtos.ReportDTO;
import com.apoiamais.platform.entities.Report;
import com.apoiamais.platform.repositories.ReportRepository;
import com.apoiamais.platform.services.exceptions.DatabaseException;
import com.apoiamais.platform.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReportService {

	@Autowired
	private ReportRepository repository;

	@Transactional(readOnly = true)
	public ReportDTO findById(Long id) {
		Report entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado, id inválido"));
		return new ReportDTO(entity);
	}

	@Transactional(readOnly = true)
	public Page<ReportDTO> findAllPaged(Pageable pageable) {
		Page<Report> report = repository.findAll(pageable);
		return report.map(item -> new ReportDTO(item));
	}

	@Transactional
	public ReportDTO insert(ReportDTO dto) {
		Report entity = new Report();
		dtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ReportDTO(entity);
	}

	@Transactional
	public ReportDTO update(Long id, ReportDTO dto) {
		try {
			Report entity = repository.getReferenceById(id);
			entity = dtoToEntity(dto, entity);
			repository.save(entity);
			return new ReportDTO(entity);
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
	
	
	private Report dtoToEntity(ReportDTO dto, Report entity) {
		entity.setId(dto.getId());
		entity.setDescription(dto.getDescription());
		entity.setDate(dto.getDate());
		return entity;

	}
}
