package com.api.stagease.DTO;

import com.api.stagease.Entity.*;
import com.api.stagease.Entity.Enum.Situacao;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SolicitacaoDTO {
    private Long id;
    private LocalEntity local;
    private EstagiarioEntity estagiario;
    private SupervisorEntity supervisor;
    private DuracaoEntity duracao;
    private List<Situacao> situacoes;
    private ExpedienteEntity expediente;
}
