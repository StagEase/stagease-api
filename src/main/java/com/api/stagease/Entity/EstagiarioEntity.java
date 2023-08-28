package com.api.stagease.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "estagiario", schema = "stagease")
public class EstagiarioEntity extends AbstractEntity{
    @Column(length = 50, nullable = false)
    private String nomeEstagiario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "curso_id", referencedColumnName = "id", nullable = false)
    private CursoEntity curso;

    @Column(length = 50, nullable = false)
    private String periodo;

    @Column(length = 50, nullable = false)
    private String instituicaoDeEnsino;
}
