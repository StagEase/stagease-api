package com.api.stagease.Service;

import com.api.stagease.DTO.UBSDTO;
import com.api.stagease.Entity.UBSEntity;
import com.api.stagease.Repository.UBSRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UBSService {
    @Autowired
    private UBSRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public UBSDTO create(UBSDTO dto) {
        if (dto.getId() != null) {
            throw new RuntimeException("Não insira o id manualmente");
        }
        UBSEntity entity = modelMapper.map(dto, UBSEntity.class);
        UBSDTO local = new UBSDTO();
        BeanUtils.copyProperties(repository.save(entity), local);
        return local;
    }

    @Transactional
    public UBSDTO update(Long id, UBSDTO dto) {
        UBSEntity banco = this.repository.findById(id).orElse(null);
        if (!banco.getId().equals(dto.getId())) {
            throw new RuntimeException("Não foi possivel encontrar o registro informado");
        }
        modelMapper.map(dto, banco);
        UBSDTO local = new UBSDTO();
        BeanUtils.copyProperties(repository.save(banco), local);
        return local;
    }

    @Transactional
    public void delete(Long id) {
        UBSEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar o registro informado"));
        repository.delete(entity);
    }
}
