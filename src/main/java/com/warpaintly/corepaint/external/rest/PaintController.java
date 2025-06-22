package com.warpaintly.corepaint.external.rest;

import com.warpaintly.corepaint.service.paint.PaintService;
import com.warpaintly.corepaint.service.paint.dto.CreatePaintRequestDTO;
import com.warpaintly.corepaint.service.paint.dto.GetPaintRequestDTO;
import com.warpaintly.corepaint.service.paint.dto.GetPaintResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/paint")
public class PaintController {

    private final PaintService paintService;

    public PaintController(PaintService paintService) {
        this.paintService = paintService;
    }

    @GetMapping()
    public ResponseEntity<List<GetPaintResponseDTO>> getBy(GetPaintRequestDTO dto) {
        return ResponseEntity.ok(paintService.get(dto));
    }

    @PostMapping
    public void create(CreatePaintRequestDTO dto) {
        paintService.create(dto);
    }

}
