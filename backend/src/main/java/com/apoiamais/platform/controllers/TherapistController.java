package com.apoiamais.platform.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apoiamais.platform.dtos.TherapistDTO;
import com.apoiamais.platform.entities.Therapist;
import com.apoiamais.platform.services.TherapistService;

@RestController
@RequestMapping(value = "/therapists")
public class TherapistController {
	@Autowired
	private TherapistService service;

	@GetMapping("/{id}")
	public ResponseEntity<TherapistDTO> findById(@PathVariable Long id) {
		TherapistDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping
	public ResponseEntity<Page<TherapistDTO>> findAll(Pageable pageable) {
		Page<TherapistDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<TherapistDTO> insert(@RequestBody TherapistDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<TherapistDTO> update(@PathVariable Long id, @RequestBody TherapistDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/update")
    public ModelAndView updateForm() {
        ModelAndView modelAndView = new ModelAndView("updatePscicologo");
        
        return modelAndView;
    }

	@PostMapping("/update")
    public String updateSubmit(@ModelAttribute Therapist therapists) {
        // Lógica para atualizar os dados do psicólogo
        // Exemplo: psicologoService.update(psicologo);
        
        return "redirect:/updatePscicologo"; // Redirecionar para a tela do psicólogo após a atualização
    }
}
