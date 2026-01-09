package com.warpaintly.corepaint.service.paint.mapper;

import com.warpaintly.corepaint.domain.paint.PaintEntity;
import com.warpaintly.corepaint.service.paint.dto.CreatePaintResponseDTO;
import com.warpaintly.corepaint.service.paint.dto.GetPaintResponseDTO;
import com.warpaintly.corepaint.service.paint.dto.UpdatePaintResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaintMapper {

    GetPaintResponseDTO toGetPaintResponseDTO(PaintEntity paint);

    CreatePaintResponseDTO toCreatePaintResponseDTO(PaintEntity paint);

    UpdatePaintResponseDTO toUpdatePaintResponseDTO(PaintEntity paint);
}
