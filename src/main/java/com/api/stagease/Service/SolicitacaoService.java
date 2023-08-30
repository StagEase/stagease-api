package com.api.stagease.Service;

import com.api.stagease.DTO.SolicitacaoDTO;
import com.api.stagease.Entity.SolicitacaoEntity;
import com.api.stagease.Repository.SolicitacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SolicitacaoService {
    @Autowired
    private SolicitacaoRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public SolicitacaoEntity create(SolicitacaoDTO dto) {
        if (dto.getId() != null) {
            throw new RuntimeException("Não insira o id manualmente");
        }
        SolicitacaoEntity entity = modelMapper.map(dto, SolicitacaoEntity.class);
        return repository.save(entity);
    }

    @Transactional
    public void update(Long id, SolicitacaoDTO dto) {
        SolicitacaoEntity banco = this.repository.findById(id).orElse(null);
        if (!banco.getId().equals(dto.getId())) {
            throw new RuntimeException("Não foi possivel encontrar o registro informado");
        }
        modelMapper.map(dto, banco);
        repository.save(banco);
    }

    @Transactional
    public void delete(Long id) {
        SolicitacaoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar o registro informado"));
        repository.delete(entity);
    }
}
