package com.warpaintly.corepaint.service.paint;

import com.warpaintly.corepaint.domain.paint.ColorGroup;
import com.warpaintly.corepaint.domain.paint.PaintBrand;
import com.warpaintly.corepaint.domain.paint.PaintEntity;
import com.warpaintly.corepaint.domain.paint.repository.PaintRepositoryImpl;
import com.warpaintly.corepaint.service.paint.dto.GetPaintRequestDTO;
import com.warpaintly.corepaint.service.paint.dto.GetPaintResponseDTO;
import com.warpaintly.corepaint.service.paint.mapper.PaintMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GetPaintUseCaseTest {

    private final static String PAINT_NAME = "Abbadon Black";
    private final static String PAINT_BRAND = "CITADEL";
    private final static String COLOR_GROUP = "BLACK";

    private final PaintRepositoryImpl paintRepository = Mockito.mock(PaintRepositoryImpl.class);
    private final PaintMapper paintMapper = Mappers.getMapper(PaintMapper.class);

    private final GetPaintUseCase getPaintUseCase = new GetPaintUseCase(
            paintRepository,
            paintMapper
    );

    @Test
    void shouldGetPaintByName() {
        // given
        GetPaintRequestDTO requestDTO = new GetPaintRequestDTO(
                PAINT_NAME,
                PAINT_BRAND,
                COLOR_GROUP
        );

        // and
        PaintEntity paint = new PaintEntity(
                PAINT_NAME,
                PaintBrand.valueOf(PAINT_BRAND),
                ColorGroup.valueOf(COLOR_GROUP)
        );

        // and
        when(paintRepository.getByName(anyString())).thenReturn(paint);

        // when
        GetPaintResponseDTO response = getPaintUseCase.execute(requestDTO);

        // then
        verify(paintRepository, times(1)).getByName(anyString());
        assertThat(requestDTO.getName()).isEqualTo(response.getName());
        assertThat(requestDTO.getBrand()).isEqualTo(response.getBrand());
        assertThat(requestDTO.getColorGroup()).isEqualTo(response.getColorGroup());
    }

}
