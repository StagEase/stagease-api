package com.api.stagease.Repository;

import com.api.stagease.Entity.DuracaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuracaoRepository extends JpaRepository<DuracaoEntity, Long> {
}
