package com.api.stagease.Controller;

import com.api.stagease.DTO.EstagiarioDTO;
import com.api.stagease.Entity.EstagiarioEntity;
import com.api.stagease.Repository.EstagiarioRepository;
import com.api.stagease.Service.EstagiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/estagiario")
public class EstagiarioController {
    @Autowired
    private EstagiarioService service;
    @Autowired
    private EstagiarioRepository repository;

    @GetMapping("/list")
    public ResponseEntity<List<EstagiarioEntity>> list() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping
    public ResponseEntity<EstagiarioDTO> getByIdRequest(@RequestParam("id") final Long id) {
        try {
            final EstagiarioEntity local = this.repository.findById(id).orElse(null);
            return ResponseEntity.ok(local);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<EstagiarioDTO> create(@RequestBody final EstagiarioDTO dto) {
        try {
            return ResponseEntity.ok(this.service.create(dto));
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstagiarioDTO> update(@PathVariable("id") final Long id, @RequestBody final EstagiarioDTO dto) {
        try {
            return ResponseEntity.ok(service.update(id, dto));
        }
        catch (DataIntegrityViolationException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") final Long id) {
        final EstagiarioEntity local = this.repository.findById(id).orElse(null);
        try {
            return ResponseEntity.ok(this.repository.delete(local));
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
