package com.api.stagease.DTO;

import com.api.stagease.Entity.CursoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstagiarioDTO {
    private Long id;
    private String nomeEstagiario;
    private CursoEntity curso;
    private String periodo;
    private String instituicaoDeEnsino;

    public EstagiarioDTO() {}

    public EstagiarioDTO(Long id, String nomeEstagiario, CursoEntity curso, String periodo, String instituicaoDeEnsino) {
        this.id = id;
        this.nomeEstagiario = nomeEstagiario;
        this.curso = curso;
        this.periodo = periodo;
        this.instituicaoDeEnsino = instituicaoDeEnsino;
    }
}
