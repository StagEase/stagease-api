package com.api.stagease.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstagiarioDTO {
    private Long id;
    private String nomeEstagiario;
    private CursoDTO curso;
    private String periodo;
    private String instituicaoDeEnsino;
}
