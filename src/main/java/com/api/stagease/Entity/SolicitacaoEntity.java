package com.api.stagease.Entity;

import com.api.stagease.Entity.Enum.Situacao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "solicitacao", schema = "stagease")
public class SolicitacaoEntity extends AbstractEntity{

    @ManyToOne(optional = false)
    @JoinColumn(name = "local_id", referencedColumnName = "id", nullable = false)
    private LocalEntity local;

    @ManyToOne(optional = false)
    @JoinColumn(name = "estagiaria_id", referencedColumnName = "id", nullable = false)
    private EstagiarioEntity estagiario;

    @OneToOne(mappedBy = "solicitacao")
    private SupervisorEntity supervisor;

    @OneToOne(mappedBy = "solicitacao")
    private DuracaoEntity duracao;

    @Column(name = "situacao", nullable = false)
    private List<Situacao> situacoes;

    @OneToOne(mappedBy = "solicitacao")
    private ExpedienteEntity expediente;
}
