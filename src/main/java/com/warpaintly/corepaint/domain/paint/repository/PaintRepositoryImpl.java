package com.warpaintly.corepaint.domain.paint.repository;

import com.warpaintly.corepaint.domain.paint.PaintEntity;
import com.warpaintly.corepaint.domain.paint.exceptions.PaintNotPresentException;
import org.springframework.stereotype.Repository;

@Repository
public class PaintRepositoryImpl {

    private final PaintJpaRepository paintJpaRepository;

    public PaintRepositoryImpl(PaintJpaRepository paintJpaRepository) {
        this.paintJpaRepository = paintJpaRepository;
    }

    public PaintEntity getByName(String name) {
        return paintJpaRepository.findByName(name)
                .orElseThrow(() -> new PaintNotPresentException(String.format("Paint with nane %s is not present!", name)
                        )
                );
    }

    public void save(PaintEntity paint) {
        paintJpaRepository.save(paint);
    }

}
