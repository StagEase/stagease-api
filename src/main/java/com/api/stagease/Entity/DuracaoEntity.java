package com.api.stagease.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter @Setter
@Entity
@Table(name = "duracao", schema = "stagease")
public class DuracaoEntity extends AbstractEntity{
    @Column(nullable = false)
    private LocalTime dataInicio;

    @Column(nullable = false)
    private LocalTime dataFim;

    @Column(nullable = false)
    private Long cargaHoraria;

    @OneToOne
    @JoinColumn(name = "solicitacao_id",nullable = false)
    private SolicitacaoEntity solicitacao;
}