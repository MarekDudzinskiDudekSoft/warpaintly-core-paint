package com.warpaintly.corepaint.service.paint;

import com.warpaintly.corepaint.domain.paint.PaintEntity;
import com.warpaintly.corepaint.domain.paint.repository.PaintRepositoryImpl;
import com.warpaintly.corepaint.service.paint.dto.GetPaintRequestDTO;
import com.warpaintly.corepaint.service.paint.dto.GetPaintResponseDTO;
import com.warpaintly.corepaint.service.paint.mapper.PaintMapper;
import org.springframework.stereotype.Component;

@Component
class GetPaintUseCase {

    private final PaintRepositoryImpl paintRepository;
    private final PaintMapper paintMapper;

    public GetPaintUseCase(PaintRepositoryImpl paintRepository,
                           PaintMapper paintMapper) {
        this.paintRepository = paintRepository;
        this.paintMapper = paintMapper;
    }

    public GetPaintResponseDTO execute(GetPaintRequestDTO request) {
        PaintEntity paint = paintRepository.getByName(request.getName());
        return paintMapper.toGetPaintResponseDTO(paint);
    }
}
