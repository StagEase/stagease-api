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
    private UBSDTO local;
    private EstagiarioDTO estagiario;
    private GerenteDTO gerente;
    private DuracaoDTO duracao;
    private List<Situacao> situacoes;
    private ExpedienteDTO expediente;
}
