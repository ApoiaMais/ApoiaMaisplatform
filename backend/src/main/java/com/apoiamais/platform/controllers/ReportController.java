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

import com.apoiamais.platform.dtos.ReportDTO;
import com.apoiamais.platform.services.ReportService;

@RestController
@RequestMapping(value = "/reports")
public class ReportController {
@Autowired
    private ReportService service;

    @GetMapping("/{id}")
    public ResponseEntity<ReportDTO> getOne(@PathVariable Long id){
        ReportDTO reportDTO = service.findById(id);
		return ResponseEntity.ok().body(reportDTO);
    }
	
	@GetMapping
	public ResponseEntity<Page<ReportDTO>> findAll(Pageable pageable) {
		Page<ReportDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}