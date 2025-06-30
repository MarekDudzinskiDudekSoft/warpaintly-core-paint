package com.warpaintly.corepaint.service.paint;

import com.warpaintly.corepaint.domain.paint.exceptions.PaintDomainOperationException;
import com.warpaintly.corepaint.domain.paint.repository.PaintRepositoryImpl;
import com.warpaintly.corepaint.service.paint.dto.CreatePaintRequestDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.warpaintly.corepaint.domain.paint.exceptions.PaintDomainOperationException.PaintDomainOperationErrorCode.PAINT_BRAND_INVALID;
import static com.warpaintly.corepaint.service.paint.PaintConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreatePaintUseCaseTest {

    private final PaintRepositoryImpl paintRepository = Mockito.mock(PaintRepositoryImpl.class);

    private final CreatePaintUseCase createPaintUseCase = new CreatePaintUseCase(
            paintRepository
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
        createPaintUseCase.execute(requestDTO);

        // then
        verify(paintRepository, times(1)).save(any());
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
