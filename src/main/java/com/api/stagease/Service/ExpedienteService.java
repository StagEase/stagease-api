package com.api.stagease.Service;

import com.api.stagease.DTO.CursoDTO;
import com.api.stagease.DTO.ExpedienteDTO;
import com.api.stagease.Entity.CursoEntity;
import com.api.stagease.Entity.ExpedienteEntity;
import com.api.stagease.Repository.ExpedienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExpedienteService {
    @Autowired
    private ExpedienteRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public ExpedienteEntity create(ExpedienteDTO dto) {
        if (dto.getId() != null) {
            throw new RuntimeException("Não insira o id manualmente");
        }
        ExpedienteEntity entity = modelMapper.map(dto, ExpedienteEntity.class);
        return repository.save(entity);
    }

    @Transactional
    public void update(Long id, ExpedienteDTO dto) {
        ExpedienteEntity banco = this.repository.findById(id).orElse(null);
        if (!banco.getId().equals(dto.getId())) {
            throw new RuntimeException("Não foi possivel encontrar o registro informado");
        }
        modelMapper.map(dto, banco);
        repository.save(banco);
    }

    @Transactional
    public void delete(Long id) {
        ExpedienteEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar o registro informado"));
        repository.delete(entity);
    }
}
