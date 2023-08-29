package com.api.stagease.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "duracao", schema = "stagease")
public class DuracaoEntity extends AbstractEntity{
    @Column(name = "data_inicio", nullable = false)
    private LocalTime dataInicio;

    @Column(name = "data_fim", nullable = false)
    private LocalTime dataFim;

    @Column(name = "carga_horaria", nullable = false)
    private Long cargaHoraria;

    @OneToOne
    @JoinColumn(name = "solicitacao_id")
    private SolicitacaoEntity solicitacao;
}
