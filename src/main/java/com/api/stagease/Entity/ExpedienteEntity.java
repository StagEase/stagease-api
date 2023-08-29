package com.api.stagease.Entity;

import com.api.stagease.Entity.Enum.Ocorrencia;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "expediente", schema = "stagease")
public class ExpedienteEntity extends AbstractEntity {
    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fim", nullable = false)
    private LocalTime horaFim;

    @Column(name = "ocorrencia", nullable = false)
    private List<Ocorrencia> ocorrencias;

    @OneToOne
    @JoinColumn(name = "solicitacao_id")
    private SolicitacaoEntity solicitacao;
}
