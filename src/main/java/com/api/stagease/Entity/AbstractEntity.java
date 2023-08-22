package com.api.stagease.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
public class AbstractEntity {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Getter
    @Setter
    @Column(name = "cadastro", nullable = false)
    private LocalDateTime cadastro;
    @Getter
    @Setter
    @Column(name = "atualizacao")
    private LocalDateTime atualizacao;
    @Getter
    @Setter
    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @PrePersist
    public void prePersist() {
        this.cadastro = LocalDateTime.now();
        this.ativo = true;
    }

    @PreUpdate
    public void preUpdate() {
        this.atualizacao = LocalDateTime.now();
    }
}
