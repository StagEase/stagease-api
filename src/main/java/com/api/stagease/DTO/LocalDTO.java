package com.api.stagease.DTO;

import com.api.stagease.Entity.CursoEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LocalDTO {
    private Long id;
    private String nomeLocal;
    private String email;
    private List<CursoEntity> ocorrencias;

    public LocalDTO() {}

    public LocalDTO(Long id, String nomeLocal, String email, List<CursoEntity> ocorrencias) {
        this.id = id;
        this.nomeLocal = nomeLocal;
        this.email = email;
        this.ocorrencias = ocorrencias;
    }
}
