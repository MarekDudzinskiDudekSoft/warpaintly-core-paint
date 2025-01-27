package com.warpaintly.corepaint.service.paint;

import com.warpaintly.corepaint.domain.paint.ColorGroup;
import com.warpaintly.corepaint.domain.paint.PaintBrand;
import com.warpaintly.corepaint.domain.paint.PaintEntity;
import com.warpaintly.corepaint.domain.paint.repository.PaintRepositoryImpl;
import com.warpaintly.corepaint.service.paint.dto.CreatePaintRequestDTO;
import org.springframework.stereotype.Component;

@Component
class CreatePaintUseCase {

    private final PaintRepositoryImpl paintRepository;

    public CreatePaintUseCase(PaintRepositoryImpl paintRepository) {
        this.paintRepository = paintRepository;
    }

    public void execute(CreatePaintRequestDTO request) {
        PaintEntity paint = new PaintEntity(
                request.getName(),
                PaintBrand.from(request.getBrand()),
                ColorGroup.from(request.getColorGroup())
        );
        paintRepository.save(paint);
    }
}
