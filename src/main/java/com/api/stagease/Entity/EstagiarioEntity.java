package com.api.stagease.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "local", schema = "stagease")
public class EstagiarioEntity extends AbstractEntity{
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 50, nullable = false)
    private String curso;
    @Column(length = 50, nullable = false)
    private String periodo;
    @Column(length = 50, nullable = false)
    private String ie;

    public EstagiarioEntity() {}

    public EstagiarioEntity(String nome, String curso, String periodo, String ie) {
        this.nome = nome;
        this.curso = curso;
        this.periodo = periodo;
        this.ie = ie;
    }
}
