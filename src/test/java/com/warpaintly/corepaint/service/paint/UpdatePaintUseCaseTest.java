package com.warpaintly.corepaint.service.paint;

import com.warpaintly.corepaint.domain.paint.ColorGroup;
import com.warpaintly.corepaint.domain.paint.PaintBrand;
import com.warpaintly.corepaint.domain.paint.PaintEntity;
import com.warpaintly.corepaint.domain.paint.PaintType;
import com.warpaintly.corepaint.domain.paint.repository.PaintRepositoryImpl;
import com.warpaintly.corepaint.service.paint.dto.UpdatePaintRequestDTO;
import com.warpaintly.corepaint.service.paint.dto.UpdatePaintResponseDTO;
import com.warpaintly.corepaint.service.paint.mapper.PaintMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;

import static com.warpaintly.corepaint.service.paint.PaintConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UpdatePaintUseCaseTest {

    private final PaintRepositoryImpl paintRepository = Mockito.mock(PaintRepositoryImpl.class);
    private final PaintMapper paintMapper = Mappers.getMapper(PaintMapper.class);

    private final UpdatePaintUseCase updatePaintUseCase = new UpdatePaintUseCase(paintRepository, paintMapper);


    @Test
    void shouldUpdatePaint() {
        // given
        UpdatePaintRequestDTO requestDTO = new UpdatePaintRequestDTO(
                PAINT_NAME_WHITE_SCAR,
                PAINT_BRAND_CITADEL,
                COLOR_GROUP_WHITE,
                PAINT_TYPE_LAYER,
                PAINT_CODE_TWO
        );

        // and
        PaintEntity paint = new PaintEntity(
                PAINT_NAME_ABBADON_BLACK,
                PaintBrand.valueOf(PAINT_BRAND_CITADEL),
                ColorGroup.valueOf(COLOR_GROUP_BLACK),
                PaintType.from(PAINT_TYPE_BASE),
                PAINT_CODE_ONE
        );

        // and
        when(paintRepository.getByUuid(any())).thenReturn(paint);

        // and
        when(paintRepository.save(any())).thenReturn(paint);

        // when
        UpdatePaintResponseDTO response = updatePaintUseCase.execute(requestDTO);

        // then
        verify(paintRepository, times(1)).save(any());
        assertThat(requestDTO.getName()).isEqualTo(response.getName());
        assertThat(requestDTO.getBrand()).isEqualTo(response.getBrand());
        assertThat(requestDTO.getColorGroup()).isEqualTo(response.getColorGroup());
        assertThat(requestDTO.getPaintType()).isEqualTo(response.getPaintType());
        assertThat(requestDTO.getCode()).isEqualTo(response.getCode());
    }
}
