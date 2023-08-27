package com.api.stagease.DTO;

import com.api.stagease.Entity.CursoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalDTO {
    private Long id;
    private String nome;
    private String email;
    private CursoEntity cursos;

    public LocalDTO() {}

    public LocalDTO(Long id, String nome, String email, CursoEntity cursos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cursos = cursos;
    }
}
