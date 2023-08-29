package com.api.stagease.DTO;

import com.api.stagease.Entity.SolicitacaoEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class DuracaoDTO {
    private Long id;
    private LocalTime dataInicio;
    private LocalTime dataFim;
    private Long cargaHoraria;
    private SolicitacaoEntity solicitacao;

    public DuracaoDTO() {}

    public DuracaoDTO(Long id, LocalTime dataInicio, LocalTime dataFim, Long cargaHoraria, SolicitacaoEntity solicitacao) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.cargaHoraria = cargaHoraria;
        this.solicitacao = solicitacao;
    }


}
