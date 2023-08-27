package com.api.stagease.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "superisor", schema = "stagease")
public class SupervisorEntity extends AbstractEntity {
    @Column(name = "nome")
    private String nomeSupervisor;
}

