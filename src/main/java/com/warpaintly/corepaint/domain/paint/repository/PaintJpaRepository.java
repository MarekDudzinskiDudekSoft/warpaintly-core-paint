package com.warpaintly.corepaint.domain.paint.repository;

import com.warpaintly.corepaint.domain.paint.PaintEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface PaintJpaRepository extends JpaRepository<PaintEntity, Long> {

    Optional<PaintEntity> findByName(String name);
}
