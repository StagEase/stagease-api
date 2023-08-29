package com.api.stagease.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "duracao", schema = "stagease")
public class DuracaoEntity extends AbstractEntity{

    @OneToOne
    @JoinColumn(name = "solicitacao_id")
    private SolicitacaoEntity solicitacao;

}
