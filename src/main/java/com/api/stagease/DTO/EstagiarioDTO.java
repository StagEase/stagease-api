package com.api.stagease.DTO;

import com.api.stagease.Entity.CursoEntity;
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
    private CursoEntity curso;
    private String periodo;
    private String instituicaoDeEnsino;
}
