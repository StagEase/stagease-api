package com.api.stagease.Repository;

import com.api.stagease.Entity.EstagiarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstagiarioRepository extends JpaRepository<EstagiarioEntity, Long> {
}