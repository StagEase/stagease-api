package com.api.stagease.DTO;

import com.api.stagease.Entity.SolicitacaoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GerenteDTO extends AbstractDTO{
    private String nomeGerente;
    private SolicitacaoDTO solicitacao;
}
