package com.api.stagease.Repository;

import com.api.stagease.Entity.SupervisorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupervisorRepository extends JpaRepository<SupervisorEntity, Long> {
}
