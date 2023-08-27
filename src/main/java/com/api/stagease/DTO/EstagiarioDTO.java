package com.api.stagease.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstagiarioDTO {
    private Long id;
    private String nome;
    private String curso;
    private String periodo;
    private String ie;

    public EstagiarioDTO() {}

    public EstagiarioDTO(Long id, String nome, String curso, String periodo, String ie) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.periodo = periodo;
        this.ie = ie;
    }
}
