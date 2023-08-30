package com.api.stagease.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DuracaoDTO extends AbstractDTO{
    private LocalTime dataInicio;
    private LocalTime dataFim;
    private Long cargaHoraria;
    private SolicitacaoDTO solicitacao;
}
