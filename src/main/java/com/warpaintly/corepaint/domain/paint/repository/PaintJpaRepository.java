package com.warpaintly.corepaint.domain.paint.repository;

import com.warpaintly.corepaint.domain.paint.PaintEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

interface PaintJpaRepository extends JpaRepository<PaintEntity, Long>, JpaSpecificationExecutor<PaintEntity> {
}
