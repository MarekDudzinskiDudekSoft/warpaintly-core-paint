package com.warpaintly.corepaint.service.paint;

import com.warpaintly.corepaint.domain.paint.exceptions.PaintDomainOperationException;
import com.warpaintly.corepaint.domain.paint.repository.PaintRepositoryImpl;
import com.warpaintly.corepaint.service.paint.dto.CreatePaintRequestDTO;
import com.warpaintly.corepaint.service.paint.dto.CreatePaintResponseDTO;
import com.warpaintly.corepaint.service.paint.mapper.PaintMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;

import static com.warpaintly.corepaint.domain.paint.exceptions.PaintDomainOperationException.PaintDomainOperationErrorCode.PAINT_BRAND_INVALID;
import static com.warpaintly.corepaint.service.paint.PaintConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreatePaintUseCaseTest {

    private final PaintRepositoryImpl paintRepository = Mockito.mock(PaintRepositoryImpl.class);
    private final PaintMapper paintMapper = Mappers.getMapper(PaintMapper.class);

    private final CreatePaintUseCase createPaintUseCase = new CreatePaintUseCase(
            paintRepository,
            paintMapper
    );

    @Test
    void shouldCreatePaint() {
        // given
        CreatePaintRequestDTO requestDTO = new CreatePaintRequestDTO(
                PAINT_NAME_ABBADON_BLACK,
                PAINT_BRAND_CITADEL,
                COLOR_GROUP_BLACK,
                PAINT_TYPE_BASE,
                PAINT_CODE_ONE
        );

        // when
        CreatePaintResponseDTO response = createPaintUseCase.execute(requestDTO);

        // then
        verify(paintRepository, times(1)).save(any());
        assertThat(requestDTO.getName()).isEqualTo(response.getName());
        assertThat(requestDTO.getBrand()).isEqualTo(response.getBrand());
        assertThat(requestDTO.getColorGroup()).isEqualTo(response.getColorGroup());
        assertThat(requestDTO.getPaintType()).isEqualTo(response.getPaintType());
        assertThat(requestDTO.getCode()).isEqualTo(response.getCode());
    }

    @Test
    void shouldThrowExceptionDueToInvalidBrandName() {
        // given
        CreatePaintRequestDTO requestDTO = new CreatePaintRequestDTO(
                PAINT_NAME_ABBADON_BLACK,
                INVALID_PAINT_BRAND,
                COLOR_GROUP_BLACK,
                PAINT_TYPE_BASE,
                PAINT_CODE_ONE
        );

        // when
        PaintDomainOperationException exception = assertThrows(
                PaintDomainOperationException.class,
                () -> createPaintUseCase.execute(requestDTO)
        );

        // then
        assertEquals(
                PAINT_BRAND_INVALID.toString(),
                exception.getErrorCode()
        );
    }

}
