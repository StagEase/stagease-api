package com.api.stagease.Service;

import com.api.stagease.DTO.DuracaoDTO;
import com.api.stagease.DTO.SolicitacaoDTO;
import com.api.stagease.Entity.DuracaoEntity;
import com.api.stagease.Entity.SolicitacaoEntity;
import com.api.stagease.Repository.DuracaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DuracaoService {
    @Autowired
    private DuracaoRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public DuracaoEntity create(DuracaoDTO dto) {
        if (dto.getId() != null) {
            throw new RuntimeException("Não insira o id manualmente");
        }
        DuracaoEntity entity = modelMapper.map(dto, DuracaoEntity.class);
        return repository.save(entity);
    }

    @Transactional
    public void update(Long id, DuracaoDTO dto) {
        DuracaoEntity banco = this.repository.findById(id).orElse(null);
        if (!banco.getId().equals(dto.getId())) {
            throw new RuntimeException("Não foi possivel encontrar o registro informado");
        }
        modelMapper.map(dto, banco);
        repository.save(banco);
    }

    @Transactional
    public void delete(Long id) {
        DuracaoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar o registro informado"));
        repository.delete(entity);
    }
}
