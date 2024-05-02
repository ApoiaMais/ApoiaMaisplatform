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

import com.apoiamais.platform.dtos.ConsultationDTO;
import com.apoiamais.platform.services.ConsultationService;

@RestController
@RequestMapping(value = "/consultations")
public class ConsultationController {
@Autowired
    private ConsultationService service;

    @GetMapping("/{id}")
    public ResponseEntity<ConsultationDTO> getOne(@PathVariable Long id){
        ConsultationDTO consultationDTO = service.findById(id);
		return ResponseEntity.ok().body(consultationDTO);
    }
	
	@GetMapping
	public ResponseEntity<Page<ConsultationDTO>> findAll(Pageable pageable) {
		Page<ConsultationDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
