package com.api.stagease.Repository;

import com.api.stagease.Entity.ExpedienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpedienteRepository extends JpaRepository<ExpedienteEntity, Long> {
}
