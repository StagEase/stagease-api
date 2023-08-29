package com.api.stagease.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LocalDTO {
    private Long id;
    private String nomeLocal;
    private String email;
    private List<CursoDTO> cursos;

}
