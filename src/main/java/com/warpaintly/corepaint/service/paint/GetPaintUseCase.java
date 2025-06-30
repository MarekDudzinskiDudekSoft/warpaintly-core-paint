package com.warpaintly.corepaint.service.paint;

import com.warpaintly.corepaint.domain.paint.PaintEntity;
import com.warpaintly.corepaint.domain.paint.PaintEntity_;
import com.warpaintly.corepaint.domain.paint.repository.PaintRepositoryImpl;
import com.warpaintly.corepaint.service.paint.dto.GetPaintRequestDTO;
import com.warpaintly.corepaint.service.paint.dto.GetPaintResponseDTO;
import com.warpaintly.corepaint.service.paint.mapper.PaintMapper;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
class GetPaintUseCase {

    private final PaintRepositoryImpl paintRepository;
    private final PaintMapper paintMapper;

    public GetPaintUseCase(PaintRepositoryImpl paintRepository,
                           PaintMapper paintMapperImpl) {
        this.paintRepository = paintRepository;
        this.paintMapper = paintMapperImpl;
    }

    public List<GetPaintResponseDTO> execute(GetPaintRequestDTO request) {
        Specification<PaintEntity> paintSpecification = createSpecification(request);

        return paintRepository.getBy(paintSpecification)
                .stream()
                .map(paintMapper::toGetPaintResponseDTO)
                .toList();
    }

    private Specification<PaintEntity> createSpecification(GetPaintRequestDTO request) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!request.getName().isBlank()) {
                predicates.add(cb.equal(root.get(PaintEntity_.NAME), request.getName()));
            }
            if (!request.getBrand().isBlank()) {
                predicates.add(cb.equal(root.get(PaintEntity_.BRAND), request.getBrand()));
            }
            if (!request.getColorGroup().isBlank()) {
                predicates.add(cb.equal(root.get(PaintEntity_.COLOR_GROUP), request.getColorGroup()));
            }

            if (!request.getPaintType().isBlank()) {
                predicates.add(cb.equal(root.get(PaintEntity_.PAINT_TYPE), request.getColorGroup()));
            }

            if (!request.getCode().isBlank()) {
                predicates.add(cb.equal(root.get(PaintEntity_.CODE), request.getColorGroup()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
