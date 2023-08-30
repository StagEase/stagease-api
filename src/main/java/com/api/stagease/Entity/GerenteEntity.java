package com.api.stagease.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "gerente", schema = "stagease")
public class GerenteEntity extends AbstractEntity {
    @Column(nullable = false)
    private String nomeGerente;

    @OneToOne(mappedBy = "gerente")
    @JoinColumn(name = "solicitacao_id")
    private SolicitacaoEntity solicitacao;
}

