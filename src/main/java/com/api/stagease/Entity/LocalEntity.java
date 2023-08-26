package com.api.stagease.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "local", schema = "stagease")
public class LocalEntity extends AbstractEntity{
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 50)
    private String email;
    @ManyToMany
    @JoinTable(
            name = "local_curso",
            joinColumns = @JoinColumn(name = "local_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<CursoEntity> cursos = new ArrayList<>();

    public LocalEntity() {}

    public LocalEntity(String nome, String email, List<CursoEntity> cursos) {
        this.nome = nome;
        this.email = email;
        this.cursos = cursos;
    }
}
