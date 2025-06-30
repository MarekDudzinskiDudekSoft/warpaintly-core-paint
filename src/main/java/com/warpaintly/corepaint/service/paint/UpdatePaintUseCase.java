package com.warpaintly.corepaint.service.paint;

import com.warpaintly.corepaint.domain.paint.ColorGroup;
import com.warpaintly.corepaint.domain.paint.PaintBrand;
import com.warpaintly.corepaint.domain.paint.PaintEntity;
import com.warpaintly.corepaint.domain.paint.PaintType;
import com.warpaintly.corepaint.domain.paint.repository.PaintRepositoryImpl;
import com.warpaintly.corepaint.service.paint.dto.UpdatePaintRequestDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UpdatePaintUseCase {

    private final PaintRepositoryImpl paintRepository;

    public UpdatePaintUseCase(PaintRepositoryImpl paintRepository) {
        this.paintRepository = paintRepository;
    }

    @Transactional
    public void execute(UpdatePaintRequestDTO request) {
        PaintEntity paint = paintRepository.getByUuid(request.getUuid());

        if(!request.getName().isBlank()){
            paint.setName(request.getName());
        }

        if(!request.getCode().isBlank()){
            paint.setCode(request.getCode());
        }

        if(!request.getBrand().isBlank()){
            paint.setBrand(PaintBrand.from(request.getBrand()));
        }

        if(!request.getColorGroup().isBlank()){
            paint.setColorGroup(ColorGroup.from(request.getColorGroup()));
        }

        if(!request.getPaintType().isBlank()){
            paint.setPaintType(PaintType.from(request.getPaintType()));
        }

        paintRepository.save(paint);
    }
}
