package com.api.stagease.DTO;

import com.api.stagease.Entity.Enum.Ocorrencia;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class ExpedienteDTO {
    private Long id;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private List<Ocorrencia> ocorrencias;
}
