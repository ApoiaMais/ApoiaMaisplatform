package com.apoiamais.platform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apoiamais.platform.dtos.UserDTO;
import com.apoiamais.platform.entities.User;
import com.apoiamais.platform.repositories.UserRepository;
import com.apoiamais.platform.services.exceptions.DatabaseException;
import com.apoiamais.platform.services.exceptions.ResourceNotFoundException;


@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado, id inválido"));
		return new UserDTO(user);
	}
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(Pageable pageable) {
		Page<User> users = repository.findAll(pageable);
		return users.map(item -> new UserDTO(item));
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		
		if(!repository.existsById(id)) {
			throw new ResourceNotFoundException("Este recurso não existe");
		}
		
		try {
			
			repository.deleteById(id);
		
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Falha de integridade referencial");
		}
		
	}

}
