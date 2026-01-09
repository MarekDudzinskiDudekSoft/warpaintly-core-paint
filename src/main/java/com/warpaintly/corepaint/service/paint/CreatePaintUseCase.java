package com.warpaintly.corepaint.service.paint;

import com.warpaintly.corepaint.domain.paint.ColorGroup;
import com.warpaintly.corepaint.domain.paint.PaintBrand;
import com.warpaintly.corepaint.domain.paint.PaintEntity;
import com.warpaintly.corepaint.domain.paint.PaintType;
import com.warpaintly.corepaint.domain.paint.repository.PaintRepositoryImpl;
import com.warpaintly.corepaint.service.paint.dto.CreatePaintRequestDTO;
import com.warpaintly.corepaint.service.paint.dto.CreatePaintResponseDTO;
import com.warpaintly.corepaint.service.paint.dto.GetPaintResponseDTO;
import com.warpaintly.corepaint.service.paint.mapper.PaintMapper;
import org.springframework.stereotype.Component;

@Component
class CreatePaintUseCase {

    private final PaintRepositoryImpl paintRepository;
    private final PaintMapper paintMapper;

    public CreatePaintUseCase(PaintRepositoryImpl paintRepository, PaintMapper paintMapper) {
        this.paintRepository = paintRepository;
        this.paintMapper = paintMapper;
    }

    public CreatePaintResponseDTO execute(CreatePaintRequestDTO request) {
        PaintEntity paint = new PaintEntity(
                request.getName(),
                PaintBrand.from(request.getBrand()),
                ColorGroup.from(request.getColorGroup()),
                PaintType.from(request.getPaintType()),
                request.getCode()
        );
        paintRepository.save(paint);

        return paintMapper.toCreatePaintResponseDTO(paint);
    }
}
