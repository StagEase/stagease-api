package com.api.stagease.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EstagiarioDTO extends AbstractDTO{
    private String nomeEstagiario;
    private AreaDTO area;
    private String periodo;
    private String instituicaoDeEnsino;
}

