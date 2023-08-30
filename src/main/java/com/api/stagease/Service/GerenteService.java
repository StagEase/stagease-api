package com.api.stagease.Service;

import com.api.stagease.DTO.GerenteDTO;
import com.api.stagease.Entity.GerenteEntity;
import com.api.stagease.Repository.GerenteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GerenteService {
    @Autowired
    private GerenteRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public GerenteEntity create(GerenteDTO dto) {
        if (dto.getId() != null) {
            throw new RuntimeException("Não insira o id manualmente");
        }
        GerenteEntity entity = modelMapper.map(dto, GerenteEntity.class);
        return repository.save(entity);
    }

    @Transactional
    public void update(Long id, GerenteDTO dto) {
        GerenteEntity banco = this.repository.findById(id).orElse(null);
        if (!banco.getId().equals(dto.getId())) {
            throw new RuntimeException("Não foi possivel encontrar o registro informado");
        }
        modelMapper.map(dto, banco);
        repository.save(banco);
    }

    @Transactional
    public void delete(Long id) {
        GerenteEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar o registro informado"));
        repository.delete(entity);
    }
}
