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

import com.apoiamais.platform.dtos.AddressDTO;
import com.apoiamais.platform.services.AddressService;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getOne(@PathVariable Long id){
        AddressDTO addressDTO = service.findById(id);
		return ResponseEntity.ok().body(addressDTO);
    }
	
	@GetMapping
	public ResponseEntity<Page<AddressDTO>> findAll(Pageable pageable) {
		Page<AddressDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
