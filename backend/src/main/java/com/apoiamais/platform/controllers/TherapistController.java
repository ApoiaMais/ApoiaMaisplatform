package com.apoiamais.platform.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apoiamais.platform.dtos.TherapistDTO;
import com.apoiamais.platform.dtos.TherapistMinDTO;
import com.apoiamais.platform.services.TherapistService;

@RestController
@RequestMapping(value = "/therapists")
public class TherapistController {
	@Autowired
	private TherapistService service;

	@GetMapping("/{id}")
	public ResponseEntity<TherapistMinDTO> findById(@PathVariable Long id) {
		TherapistMinDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping
	public ResponseEntity<Page<TherapistMinDTO>> findAll(Pageable pageable) {
		Page<TherapistMinDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<TherapistMinDTO> insert(@RequestBody TherapistDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		TherapistMinDTO patientMinDTO = new TherapistMinDTO(dto);
		return ResponseEntity.created(uri).body(patientMinDTO);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<TherapistMinDTO> update(@PathVariable Long id, @RequestBody TherapistMinDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
