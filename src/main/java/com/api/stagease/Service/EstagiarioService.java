package com.api.stagease.Service;

import com.api.stagease.DTO.EstagiarioDTO;
import com.api.stagease.Entity.EstagiarioEntity;
import com.api.stagease.Repository.EstagiarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstagiarioService {
    @Autowired
    private EstagiarioRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public EstagiarioEntity create(EstagiarioDTO dto) {
        if (dto.getId() != null) {
            throw new RuntimeException("Não insira o id manualmente");
        }
        EstagiarioEntity entity = modelMapper.map(dto, EstagiarioEntity.class);
        return repository.save(entity);
    }

    @Transactional
    public EstagiarioEntity update(Long id, EstagiarioDTO dto) {
        EstagiarioEntity banco = this.repository.findById(id).orElse(null);
        if (!banco.getId().equals(dto.getId())) {
            throw new RuntimeException("Não foi possivel encontrar o registro informado");
        }
        modelMapper.map(dto, banco);
        return repository.save(banco);
    }

    @Transactional
    public void delete(Long id) {
        EstagiarioEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar o registro informado"));
        repository.delete(entity);
    }
}
