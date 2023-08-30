package com.api.stagease.DTO;

import com.api.stagease.Entity.ExpedienteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EstagiarioDTO extends AbstractDTO{
    private String nomeEstagiario;
    private AreaDTO areaEstagiario;
    private String periodo;
    private String instituicaoDeEnsino;
    private ExpedienteEntity expediente;
    private String matricula;
    private int termo;
}

