package com.api.stagease.Controller;

import com.api.stagease.DTO.CursoDTO;
import com.api.stagease.Entity.CursoEntity;
import com.api.stagease.Repository.CursoRepository;
import com.api.stagease.Service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/curso")
public class CursoController {
    @Autowired
    private CursoService service;
    @Autowired
    private CursoRepository repository;

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping
    public ResponseEntity<?> getByIdRequest(@RequestParam("id") final Long id) {
        final CursoEntity entity = this.repository.findById(id).orElse(null);
        return entity == null ? ResponseEntity.badRequest().body("Esse registro não existe") : ResponseEntity.ok(entity);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CursoDTO dto) {
        try {
            service.create(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro " + e.getMessage());
        }
        return ResponseEntity.ok("Registro cadastrado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") final Long id, @RequestBody final CursoDTO dto) {
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
