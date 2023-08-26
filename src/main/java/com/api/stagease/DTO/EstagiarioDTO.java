package com.api.stagease.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstagiarioDTO {
    private String nome;
    private String curso;
    private String periodo;
    private String ie;

    public EstagiarioDTO() {}

    public EstagiarioDTO(String nome, String curso, String periodo, String ie) {
        this.nome = nome;
        this.curso = curso;
        this.periodo = periodo;
        this.ie = ie;
    }
}
