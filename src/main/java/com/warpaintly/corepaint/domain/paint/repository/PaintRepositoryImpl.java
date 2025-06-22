package com.warpaintly.corepaint.domain.paint.repository;

import com.warpaintly.corepaint.domain.paint.PaintEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaintRepositoryImpl {

    private final PaintJpaRepository paintJpaRepository;

    public PaintRepositoryImpl(PaintJpaRepository paintJpaRepository) {
        this.paintJpaRepository = paintJpaRepository;
    }

    public List<PaintEntity> getBy(Specification<PaintEntity> specification) {
        return paintJpaRepository.findAll(specification);
    }

    public void save(PaintEntity paint) {
        paintJpaRepository.save(paint);
    }

}
