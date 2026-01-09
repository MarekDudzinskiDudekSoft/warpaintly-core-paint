package com.warpaintly.corepaint.service.paint;

import com.warpaintly.corepaint.service.paint.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaintService {

    private final GetPaintUseCase getPaintUseCase;
    private final CreatePaintUseCase createPaintUseCase;
    private final UpdatePaintUseCase updatePaintUseCase;

    public PaintService(GetPaintUseCase getPaintUseCase,
                        CreatePaintUseCase createPaintUseCase,
                        UpdatePaintUseCase updatePaintUseCase) {
        this.getPaintUseCase = getPaintUseCase;
        this.createPaintUseCase = createPaintUseCase;
        this.updatePaintUseCase = updatePaintUseCase;
    }

    public List<GetPaintResponseDTO> get(GetPaintRequestDTO request) {
        return getPaintUseCase.execute(request);
    }

    public CreatePaintResponseDTO create(CreatePaintRequestDTO request) {
       return createPaintUseCase.execute(request);
    }

    public UpdatePaintResponseDTO update(UpdatePaintRequestDTO request) {
       return updatePaintUseCase.execute(request);
    }
}
