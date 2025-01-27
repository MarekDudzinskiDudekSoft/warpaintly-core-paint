package com.warpaintly.corepaint.external.rest;

import com.warpaintly.corepaint.service.paint.PaintService;
import com.warpaintly.corepaint.service.paint.dto.CreatePaintRequestDTO;
import com.warpaintly.corepaint.service.paint.dto.GetPaintRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/paint")
public class PaintController {

    private final PaintService paintService;

    public PaintController(PaintService paintService) {
        this.paintService = paintService;
    }

    @GetMapping()
    public ResponseEntity<GetPaintRequestDTO> get(GetPaintRequestDTO dto) {
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public void create(CreatePaintRequestDTO dto) {
        paintService.create(dto);
    }



}
