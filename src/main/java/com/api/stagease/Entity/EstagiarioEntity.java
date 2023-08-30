package com.api.stagease.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "estagiario", schema = "stagease")
public class EstagiarioEntity extends AbstractEntity{
    @Column(length = 50, nullable = false)
    private String nomeEstagiario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "area_id", nullable = false)
    private AreaEntity areaEstagiario;

    @Column(length = 50, nullable = false)
    private String periodo;

    @Column(length = 50, nullable = false)
    private String instituicaoDeEnsino;

    @OneToOne(mappedBy = "estagiario")
    @JoinColumn(name = "expediente_id", nullable = false)
    private ExpedienteEntity expediente;

    @Column(length = 50, nullable = false)
    private String matricula;

    @Column(name = "endereco_termo")
    private int termo;
}