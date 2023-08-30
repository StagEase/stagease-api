package com.api.stagease.Entity;

import com.api.stagease.Entity.Enum.Situacao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "solicitacao", schema = "stagease")
public class SolicitacaoEntity extends AbstractEntity{

    @ManyToOne(optional = false)
    @JoinColumn(name = "ubs_id", nullable = false)
    private UBSEntity ubs;

    @ManyToOne(optional = false)
    @JoinColumn(name = "estagiarios_id", nullable = false)
    private EstagiarioEntity estagiarios;

    @OneToOne(mappedBy = "solicitacao")
    @JoinColumn(name = "gerente_id", nullable = false)
    private GerenteEntity gerente;

    @OneToOne(mappedBy = "solicitacao")
    @JoinColumn(name = "duracao_id", nullable = false)
    private DuracaoEntity duracao;

    @Enumerated
    @Column(name = "situacao", nullable = false)
    private Situacao situacao;
}