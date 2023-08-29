package com.api.stagease.DTO;

import com.api.stagease.Entity.CursoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocalDTO {
    private Long id;
    private String nomeLocal;
    private String email;
    private List<LocalDTO> ocorrencias;
}
