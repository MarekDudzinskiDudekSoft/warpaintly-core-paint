package com.warpaintly.corepaint.service.paint;

import com.warpaintly.corepaint.service.paint.dto.CreatePaintRequestDTO;
import com.warpaintly.corepaint.service.paint.dto.GetPaintRequestDTO;
import com.warpaintly.corepaint.service.paint.dto.GetPaintResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class PaintService {

    private final GetPaintUseCase getPaintUseCase;
    private final CreatePaintUseCase createPaintUseCase;

    public PaintService(GetPaintUseCase getPaintUseCase,
                        CreatePaintUseCase createPaintUseCase) {
        this.getPaintUseCase = getPaintUseCase;
        this.createPaintUseCase = createPaintUseCase;
    }

    public GetPaintResponseDTO get(GetPaintRequestDTO request) {
        return getPaintUseCase.execute(request);
    }

    public void create(CreatePaintRequestDTO request) {
        createPaintUseCase.execute(request);
    }
}
