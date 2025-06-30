package com.warpaintly.corepaint.domain.paint.repository;

import com.warpaintly.corepaint.domain.paint.PaintEntity;
import com.warpaintly.corepaint.domain.paint.exceptions.PaintDomainOperationException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.warpaintly.corepaint.domain.paint.exceptions.PaintDomainOperationException.PaintDomainOperationErrorCode.PAINT_NOT_FOUND;

@Repository
public class PaintRepositoryImpl {

    private final PaintJpaRepository paintJpaRepository;

    public PaintRepositoryImpl(PaintJpaRepository paintJpaRepository) {
        this.paintJpaRepository = paintJpaRepository;
    }

    public PaintEntity getByUuid(String uuid) {
        return paintJpaRepository
                .findByUuid(uuid)
                .orElseThrow(() -> new PaintDomainOperationException(PAINT_NOT_FOUND, "Paint with uuid " + uuid + " not found"));
    }

    public List<PaintEntity> getBy(Specification<PaintEntity> specification) {
        return paintJpaRepository.findAll(specification);
    }

    public void save(PaintEntity paint) {
        paintJpaRepository.save(paint);
    }

}
