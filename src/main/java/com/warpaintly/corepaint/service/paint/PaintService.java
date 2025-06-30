package com.warpaintly.corepaint.service.paint;

import com.warpaintly.corepaint.service.paint.dto.CreatePaintRequestDTO;
import com.warpaintly.corepaint.service.paint.dto.GetPaintRequestDTO;
import com.warpaintly.corepaint.service.paint.dto.GetPaintResponseDTO;
import com.warpaintly.corepaint.service.paint.dto.UpdatePaintRequestDTO;
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

    public void create(CreatePaintRequestDTO request) {
        createPaintUseCase.execute(request);
    }

    public void update(UpdatePaintRequestDTO request) {
        updatePaintUseCase.execute(request);
    }
}
