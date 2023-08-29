package com.api.stagease.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "solicitacao", schema = "stagease")
public class SolicitacaoEntity extends AbstractEntity{



}
