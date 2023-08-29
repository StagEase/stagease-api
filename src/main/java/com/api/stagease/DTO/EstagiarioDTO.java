package com.api.stagease.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EstagiarioDTO {
    private Long id;
    private String nomeEstagiario;
    private CursoDTO curso;
    private String periodo;
    private String instituicaoDeEnsino;
}

