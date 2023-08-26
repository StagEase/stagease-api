package com.api.stagease.Repository;

import com.api.stagease.Entity.EstagiarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstagiarioRepository extends JpaRepository<EstagiarioEntity, Long> {}