package com.warpaintly.corepaint.service.paint.mapper;

import com.warpaintly.corepaint.domain.paint.PaintEntity;
import com.warpaintly.corepaint.service.paint.dto.GetPaintResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaintMapper {

    GetPaintResponseDTO toGetPaintResponseDTO(PaintEntity paint);
}
