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
    private AreaEntity area;

    @Column(length = 50, nullable = false)
    private String periodo;

    @Column(length = 50, nullable = false)
    private String instituicaoDeEnsino;
}