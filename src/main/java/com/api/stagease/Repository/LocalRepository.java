package com.api.stagease.Repository;

import com.api.stagease.Entity.LocalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalRepository extends JpaRepository<LocalEntity, Long> {}