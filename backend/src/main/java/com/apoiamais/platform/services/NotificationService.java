package com.apoiamais.platform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apoiamais.platform.dtos.NotificationDTO;
import com.apoiamais.platform.entities.Notification;
import com.apoiamais.platform.repositories.NotificationRepository;
import com.apoiamais.platform.services.exceptions.DatabaseException;
import com.apoiamais.platform.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository repository;

	@Transactional(readOnly = true)
	public NotificationDTO findById(Long id) {
		Notification entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado, id inválido"));
		return new NotificationDTO(entity);
	}

	@Transactional(readOnly = true)
	public Page<NotificationDTO> findAllPaged(Pageable pageable) {
		Page<Notification> notification = repository.findAll(pageable);
		return notification.map(item -> new NotificationDTO(item));
	}

	@Transactional
	public NotificationDTO insert(NotificationDTO dto) {
		Notification entity = new Notification();
		dtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new NotificationDTO(entity);
	}

	@Transactional
	public NotificationDTO update(Long id, NotificationDTO dto) {
		try {
			Notification entity = repository.getReferenceById(id);
			entity = dtoToEntity(dto, entity);
			repository.save(entity);
			return new NotificationDTO(entity);
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

	private Notification dtoToEntity(NotificationDTO dto, Notification entity) {
		entity.setId(dto.getId());
		entity.setMoment(dto.getMoment());
		entity.setRead(dto.isRead());
		entity.setRoute(dto.getRoute());
		entity.setText(dto.getText());
		return entity;

	}
}
