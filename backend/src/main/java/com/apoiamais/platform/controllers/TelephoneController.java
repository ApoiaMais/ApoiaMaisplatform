package com.apoiamais.platform.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apoiamais.platform.dtos.TelephoneDTO;
import com.apoiamais.platform.services.TelephoneService;

@RestController
@RequestMapping(value = "/telephone")
public class TelephoneController {

    @Autowired
    private TelephoneService service;

    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<Page<TelephoneDTO>> findAll(Pageable pageable) {
        Page<TelephoneDTO> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @Transactional(readOnly = true)
    @GetMapping(value = "/{id}")
    public ResponseEntity<TelephoneDTO> findAll(@PathVariable Long id) {
        TelephoneDTO category = (TelephoneDTO) service.findById(id);

        return ResponseEntity.ok().body(category);
    }

    @Transactional(readOnly = true)
    @PostMapping
    public ResponseEntity<TelephoneDTO> insert(@RequestBody TelephoneDTO dto) {
        dto = (TelephoneDTO) service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


    @Transactional(readOnly = true)
    @PutMapping(value = "/{id}")
    public ResponseEntity<TelephoneDTO> update(@PathVariable Long id, @RequestBody TelephoneDTO dto) {
        dto = (TelephoneDTO) service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }
    
    @Transactional(readOnly = true)
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}