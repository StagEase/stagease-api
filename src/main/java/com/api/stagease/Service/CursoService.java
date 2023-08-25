package com.api.stagease.Service;

import com.api.stagease.DTO.CursoDTO;
import com.api.stagease.Entity.CursoEntity;
import com.api.stagease.Repository.CursoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public CursoEntity create(CursoDTO dto) {
        if (dto.getId() != null) {
            throw new RuntimeException("Não insira o id manualmente");
        }
        CursoEntity curso = modelMapper.map(dto, CursoEntity.class);
        return repository.save(curso);
    }

    @Transactional
    public void update(Long id, CursoDTO dto) {
        CursoEntity banco = this.repository.findById(id).orElse(null);
        if (!banco.getId().equals(dto.getId())) {
            throw new RuntimeException("Não foi possivel encontrar o registro informado");
        }
        modelMapper.map(dto, banco);
        repository.save(banco);
    }

    @Transactional
    public void delete(Long id) {
        CursoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar o registro informado"));
        repository.delete(entity);
    }
}
