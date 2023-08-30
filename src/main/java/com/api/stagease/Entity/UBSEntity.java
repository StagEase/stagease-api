package com.api.stagease.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "ubs", schema = "stagease")
public class UBSEntity extends AbstractEntity{
    @Column(length = 50, nullable = false, unique = true)
    private String nomeUBS;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "ubs_area",
            joinColumns = @JoinColumn(name = "ubs_id"),
            inverseJoinColumns = @JoinColumn(name = "area_id")
    )
    private List<AreaEntity> areas;
}