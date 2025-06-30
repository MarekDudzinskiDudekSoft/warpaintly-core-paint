package com.warpaintly.corepaint.domain.paint.repository;

import com.warpaintly.corepaint.domain.paint.PaintEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;


interface PaintJpaRepository extends JpaRepository<PaintEntity, Long>, JpaSpecificationExecutor<PaintEntity> {

    Optional<PaintEntity> findByUuid(String uuid);
}
