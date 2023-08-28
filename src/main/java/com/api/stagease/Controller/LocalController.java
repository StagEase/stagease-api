package com.api.stagease.Controller;

import com.api.stagease.DTO.LocalDTO;
import com.api.stagease.Entity.LocalEntity;
import com.api.stagease.Repository.LocalRepository;
import com.api.stagease.Service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/local")
public class LocalController {
    @Autowired
    private LocalService service;
    @Autowired
    private LocalRepository repository;

    @GetMapping("/list")
    public ResponseEntity<List<LocalEntity>> list() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping
    public ResponseEntity<LocalEntity> getByIdRequest(@RequestParam("id") final Long id) {
        try {
            final LocalEntity local = this.repository.findById(id).orElse(null);
            return ResponseEntity.ok(local);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<LocalEntity> create(@RequestBody final LocalDTO dto) {
        try {
            return ResponseEntity.ok(this.service.create(dto));
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") final Long id, @RequestBody final LocalDTO dto) {
        try {
            service.update(id, dto);
        }
        catch (DataIntegrityViolationException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return ResponseEntity.ok("Registro atualizado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") final Long id) {
        final LocalEntity local = this.repository.findById(id).orElse(null);
        try {
            this.repository.delete(local);
            return ResponseEntity.ok("Local deletado com sucesso");
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
