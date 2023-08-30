package com.api.stagease.Repository;

import com.api.stagease.Entity.GerenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenteRepository extends JpaRepository<GerenteEntity, Long> {
}
