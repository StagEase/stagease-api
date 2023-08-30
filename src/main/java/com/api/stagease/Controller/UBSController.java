package com.api.stagease.Controller;

import com.api.stagease.DTO.UBSDTO;
import com.api.stagease.Entity.UBSEntity;
import com.api.stagease.Repository.UBSRepository;
import com.api.stagease.Service.UBSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/ubs")
public class UBSController {
    @Autowired
    private UBSService service;
    @Autowired
    private UBSRepository repository;

    @GetMapping("/list")
    public ResponseEntity<List<UBSEntity>> list() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping
    public ResponseEntity<UBSEntity> getByIdRequest(@RequestParam("id") final Long id) {
        try {
            final UBSEntity local = this.repository.findById(id).orElse(null);
            return ResponseEntity.ok(local);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<UBSDTO> create(@RequestBody final UBSDTO dto) {
        try {
            return ResponseEntity.ok(this.service.create(dto));
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UBSDTO> update(@PathVariable("id") final Long id, @RequestBody final UBSDTO dto) {
        try {
            return ResponseEntity.ok(service.update(id, dto));
        }
        catch (DataIntegrityViolationException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<HttpStatus> delete(@PathVariable("id") final Long id) {
//        final LocalEntity local = this.repository.findById(id).orElse(null);
//        try {
//            this.repository.delete(local);
//            return ResponseEntity.ok("Local deletado com sucesso");
//        } catch (RuntimeException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
//        }
//    }
}
