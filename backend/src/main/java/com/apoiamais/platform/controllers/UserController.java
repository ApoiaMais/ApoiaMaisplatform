package com.apoiamais.platform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apoiamais.platform.dtos.UserDTO;
import com.apoiamais.platform.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
    private UserService service;
	
	@GetMapping("/{id}")
    public ResponseEntity<UserDTO> getOne(@PathVariable Long id){
        UserDTO userDTO = service.findById(id);
		return ResponseEntity.ok().body(userDTO);
    }
	
	@GetMapping
	public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable) { 
		
		Page<UserDTO> list = service.findAllPaged(pageable);
		
		return ResponseEntity.ok().body(list);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
