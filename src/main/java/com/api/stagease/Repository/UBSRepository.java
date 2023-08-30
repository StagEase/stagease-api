package com.api.stagease.Repository;

import com.api.stagease.Entity.UBSEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UBSRepository extends JpaRepository<UBSEntity, Long> {
}