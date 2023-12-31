package com.api.stagease.Entity;

import com.api.stagease.Entity.Enum.Ocorrencia;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "expediente", schema = "stagease")
public class ExpedienteEntity extends AbstractEntity {
    @Column(nullable = false)
    private LocalTime horaInicio;

    @Column(nullable = false)
    private LocalTime horaFim;

    @Enumerated
    @Column(nullable = false)
    private List<Ocorrencia> ocorrencias;
}