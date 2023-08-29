package com.api.stagease.DTO;

import com.api.stagease.Entity.Enum.Situacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitacaoDTO {
    private Long id;
    private LocalDTO local;
    private EstagiarioDTO estagiario;
    private SupervisorDTO supervisor;
    private DuracaoDTO duracao;
    private List<Situacao> situacoes;
    private ExpedienteDTO expediente;
}
