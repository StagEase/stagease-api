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
    @Column(length = 50, nullable = false, unique = true)
    private String nomeLocal;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "local_curso",
            joinColumns = @JoinColumn(name = "local_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<CursoEntity> cursos;
}
