package com.api.stagease.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "endereco", schema = "stagease")
public class EnderecoEntity extends AbstractEntity {
    @Column(name = "nome_rua", nullable = false, length = 30)
    private String nomeRua;

    @Column(name = "numero_casa", nullable = false)
    private int numeroCasa;

    @Column(name = "cep", nullable = false)
    private int cep;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "contato_id")
    private ContatoEntity contato;
}
