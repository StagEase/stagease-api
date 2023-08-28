package com.api.stagease.Repository;

import com.api.stagease.Entity.LocalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<LocalEntity, Long> {
}