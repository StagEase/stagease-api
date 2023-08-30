package com.api.stagease.Controller;

import com.api.stagease.DTO.GerenteDTO;
import com.api.stagease.Entity.GerenteEntity;
import com.api.stagease.Repository.GerenteRepository;
import com.api.stagease.Service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/gerente")
public class GerenteController {
    @Autowired
    private GerenteService service;
    @Autowired
    private GerenteRepository repository;

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping
    public ResponseEntity<?> getByIdRequest(@RequestParam("id") final Long id) {
        final GerenteEntity entity = this.repository.findById(id).orElse(null);
        return entity == null ? ResponseEntity.badRequest().body("Esse registro não existe") : ResponseEntity.ok(entity);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody GerenteDTO dto) {
        try {
            service.create(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro " + e.getMessage());
        }
        return ResponseEntity.ok("Registro cadastrado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") final Long id, @RequestBody final GerenteDTO dto) {
        try {
            service.update(id, dto);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("Erro " + e.getCause().getCause().getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro " + e.getMessage());
        }
        return ResponseEntity.ok("Registro atualizado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
        try {
            service.delete(id);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Não foi possivel deletar");
        }
        return ResponseEntity.ok("Registro deletado");
    }
}
