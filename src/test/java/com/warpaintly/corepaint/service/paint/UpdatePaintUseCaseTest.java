package com.warpaintly.corepaint.service.paint;

import com.warpaintly.corepaint.domain.paint.ColorGroup;
import com.warpaintly.corepaint.domain.paint.PaintBrand;
import com.warpaintly.corepaint.domain.paint.PaintEntity;
import com.warpaintly.corepaint.domain.paint.PaintType;
import com.warpaintly.corepaint.domain.paint.repository.PaintRepositoryImpl;
import com.warpaintly.corepaint.service.paint.dto.UpdatePaintRequestDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.warpaintly.corepaint.service.paint.PaintConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UpdatePaintUseCaseTest {

    private final PaintRepositoryImpl paintRepository = Mockito.mock(PaintRepositoryImpl.class);

    private final UpdatePaintUseCase updatePaintUseCase = new UpdatePaintUseCase(paintRepository);


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

        // when
        updatePaintUseCase.execute(requestDTO);

        // and
        PaintEntity updatedPaint = paintRepository.getByUuid(paint.getUuid());

        // then
        verify(paintRepository, times(1)).save(any());
        assertThat(requestDTO.getName()).isEqualTo(updatedPaint.getName());
        assertThat(PaintBrand.valueOf(requestDTO.getBrand())).isEqualTo(updatedPaint.getBrand());
        assertThat(ColorGroup.valueOf(requestDTO.getColorGroup())).isEqualTo(updatedPaint.getColorGroup());
        assertThat(PaintType.from(requestDTO.getPaintType())).isEqualTo(updatedPaint.getPaintType());
        assertThat(requestDTO.getCode()).isEqualTo(updatedPaint.getCode());
    }
}
