package com.api.stagease.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "curso", schema = "stagease")
public class CursoEntity extends AbstractEntity {
    @Column(name = "curso", length = 50, nullable = false)
    private String nomeCurso;
}
