package com.api.stagease.Service;

import com.api.stagease.DTO.CursoDTO;
import com.api.stagease.DTO.SupervisorDTO;
import com.api.stagease.Entity.CursoEntity;
import com.api.stagease.Entity.SupervisorEntity;
import com.api.stagease.Repository.SupervisorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupervisorService {
    @Autowired
    private SupervisorRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public SupervisorEntity create(SupervisorDTO dto) {
        if (dto.getId() != null) {
            throw new RuntimeException("Não insira o id manualmente");
        }
        SupervisorEntity entity = modelMapper.map(dto, SupervisorEntity.class);
        return repository.save(entity);
    }

    @Transactional
    public void update(Long id, SupervisorDTO dto) {
        SupervisorEntity banco = this.repository.findById(id).orElse(null);
        if (!banco.getId().equals(dto.getId())) {
            throw new RuntimeException("Não foi possivel encontrar o registro informado");
        }
        modelMapper.map(dto, banco);
        repository.save(banco);
    }

    @Transactional
    public void delete(Long id) {
        SupervisorEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar o registro informado"));
        repository.delete(entity);
    }
}
