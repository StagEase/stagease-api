package com.api.stagease.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "curso", schema = "stagease")
public class CursoEntity extends AbstractEntity {
    @Size(min = 3, max = 5, message = "Deu certo mano, mais ou menos")
    @Column(length = 50, nullable = false, unique = true)
    private String nomeCurso;
}