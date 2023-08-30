package com.api.stagease.DTO;

import com.api.stagease.Entity.Enum.Situacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitacaoDTO extends AbstractDTO{
    private UBSDTO ubs;
    private EstagiarioDTO estagiarios;
    private GerenteDTO gerente;
    private DuracaoDTO duracao;
    private Situacao situacao;
}
