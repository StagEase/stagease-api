package com.api.stagease.Service;

import com.api.stagease.DTO.LocalDTO;
import com.api.stagease.Entity.LocalEntity;
import com.api.stagease.Repository.LocalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LocalService {
    @Autowired
    private LocalRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public LocalEntity create(LocalDTO dto) {
        if (dto.getId() != null) {
            throw new RuntimeException("Não insira o id manualmente");
        }
        LocalEntity entity = modelMapper.map(dto, LocalEntity.class);
        return repository.save(entity);
    }

    @Transactional
    public void update(Long id, LocalDTO dto) {
        LocalEntity banco = this.repository.findById(id).orElse(null);
        if (!banco.getId().equals(dto.getId())) {
            throw new RuntimeException("Não foi possivel encontrar o registro informado");
        }
        modelMapper.map(dto, banco);
        repository.save(banco);
    }

    @Transactional
    public void delete(Long id) {
        LocalEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar o registro informado"));
        repository.delete(entity);
    }
}
