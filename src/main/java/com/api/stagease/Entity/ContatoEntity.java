package com.api.stagease.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "contato", schema = "stagease")
public class ContatoEntity extends AbstractEntity {
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "numero_telefone", nullable = false)
    private int numeroTelefone;

    @JsonIgnore
    @OneToMany(mappedBy = "contato", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<EnderecoEntity> enderecos;
}
