package com.warpaintly.corepaint.service.paint;

import com.warpaintly.corepaint.domain.paint.ColorGroup;
import com.warpaintly.corepaint.domain.paint.PaintBrand;
import com.warpaintly.corepaint.domain.paint.PaintEntity;
import com.warpaintly.corepaint.domain.paint.exceptions.PaintDomainOperationException;
import com.warpaintly.corepaint.domain.paint.repository.PaintRepositoryImpl;
import com.warpaintly.corepaint.service.paint.dto.CreatePaintRequestDTO;
import com.warpaintly.corepaint.service.paint.dto.GetPaintRequestDTO;
import com.warpaintly.corepaint.service.paint.dto.GetPaintResponseDTO;
import com.warpaintly.corepaint.service.paint.mapper.PaintMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;

import static com.warpaintly.corepaint.domain.paint.exceptions.PaintDomainOperationException.PaintDomainOperationErrorCode.PAINT_BRAND_INVALID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CreatePaintUseCaseTest {

    private final static String PAINT_NAME = "Abbadon Black";
    private final static String PAINT_BRAND = "CITADEL";
    private final static String INVALID_PAINT_BRAND = "INVALID_PAINT_BRAND";
    private final static String COLOR_GROUP = "BLACK";

    private final PaintRepositoryImpl paintRepository = Mockito.mock(PaintRepositoryImpl.class);

    private final CreatePaintUseCase getPaintUseCase = new CreatePaintUseCase(
            paintRepository
    );

    @Test
    void shouldCreatePaint() {
        // given
        CreatePaintRequestDTO requestDTO = new CreatePaintRequestDTO(
                PAINT_NAME,
                PAINT_BRAND,
                COLOR_GROUP
        );

        // when
        getPaintUseCase.execute(requestDTO);

        // then
        verify(paintRepository, times(1)).save(any());
    }

    @Test
    void shouldThrowExceptionDueToInvalidBrandName() {
        // given
        CreatePaintRequestDTO requestDTO = new CreatePaintRequestDTO(
                PAINT_NAME,
                INVALID_PAINT_BRAND,
                COLOR_GROUP
        );

        // when
        PaintDomainOperationException exception = assertThrows(
                PaintDomainOperationException.class,
                () ->  getPaintUseCase.execute(requestDTO)
        );

        // then
        assertEquals(
                PAINT_BRAND_INVALID.toString(),
                exception.getErrorCode()
        );
    }

}
