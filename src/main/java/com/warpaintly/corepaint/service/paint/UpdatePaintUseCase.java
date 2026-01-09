package com.warpaintly.corepaint.service.paint;

import com.warpaintly.corepaint.domain.paint.ColorGroup;
import com.warpaintly.corepaint.domain.paint.PaintBrand;
import com.warpaintly.corepaint.domain.paint.PaintEntity;
import com.warpaintly.corepaint.domain.paint.PaintType;
import com.warpaintly.corepaint.domain.paint.repository.PaintRepositoryImpl;
import com.warpaintly.corepaint.service.paint.dto.UpdatePaintRequestDTO;
import com.warpaintly.corepaint.service.paint.dto.UpdatePaintResponseDTO;
import com.warpaintly.corepaint.service.paint.mapper.PaintMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UpdatePaintUseCase {

    private final PaintRepositoryImpl paintRepository;
    private final PaintMapper paintMapper;

    public UpdatePaintUseCase(PaintRepositoryImpl paintRepository, PaintMapper paintMapper) {
        this.paintRepository = paintRepository;
        this.paintMapper = paintMapper;
    }

    @Transactional
    public UpdatePaintResponseDTO execute(UpdatePaintRequestDTO request) {
        PaintEntity paint = paintRepository.getByUuid(request.getUuid());

        if (!request.getName().isBlank()) {
            paint.setName(request.getName());
        }

        if (!request.getCode().isBlank()) {
            paint.setCode(request.getCode());
        }

        if (!request.getBrand().isBlank()) {
            paint.setBrand(PaintBrand.from(request.getBrand()));
        }

        if (!request.getColorGroup().isBlank()) {
            paint.setColorGroup(ColorGroup.from(request.getColorGroup()));
        }

        if (!request.getPaintType().isBlank()) {
            paint.setPaintType(PaintType.from(request.getPaintType()));
        }

        PaintEntity updatedPaint = paintRepository.save(paint);

        return paintMapper.toUpdatePaintResponseDTO(updatedPaint);
    }
}
