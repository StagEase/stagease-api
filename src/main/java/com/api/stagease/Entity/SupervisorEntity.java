package com.api.stagease.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "superisor", schema = "stagease")
public class SupervisorEntity extends AbstractEntity {
    @Column(name = "nome", nullable = false)
    private String nomeSupervisor;

    @OneToOne
    @JoinColumn(name = "solicitacao_id")
    private SolicitacaoEntity solicitacao;
}

