package com.warpaintly.corepaint.service.paint;

import com.warpaintly.corepaint.domain.paint.ColorGroup;
import com.warpaintly.corepaint.domain.paint.PaintBrand;
import com.warpaintly.corepaint.domain.paint.PaintEntity;
import com.warpaintly.corepaint.domain.paint.PaintType;
import com.warpaintly.corepaint.domain.paint.repository.PaintRepositoryImpl;
import com.warpaintly.corepaint.service.paint.dto.GetPaintRequestDTO;
import com.warpaintly.corepaint.service.paint.dto.GetPaintResponseDTO;
import com.warpaintly.corepaint.service.paint.mapper.PaintMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;

import java.util.List;

import static com.warpaintly.corepaint.service.paint.PaintConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GetPaintUseCaseTest {

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
                PAINT_NAME_ABBADON_BLACK,
                PAINT_BRAND_CITADEL,
                COLOR_GROUP_BLACK,
                PAINT_TYPE_BASE,
                PAINT_CODE_ONE
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
        when(paintRepository.getBy(any())).thenReturn(List.of(paint));

        // when
        List<GetPaintResponseDTO> response = getPaintUseCase.execute(requestDTO);
        GetPaintResponseDTO responseDTO = response.get(0);

        // then
        verify(paintRepository, times(1)).getBy(any());
        assertThat(response).hasSize(1);
        assertThat(requestDTO.getName()).isEqualTo(responseDTO.getName());
        assertThat(requestDTO.getBrand()).isEqualTo(responseDTO.getBrand());
        assertThat(requestDTO.getColorGroup()).isEqualTo(responseDTO.getColorGroup());
        assertThat(requestDTO.getPaintType()).isEqualTo(responseDTO.getPaintType());
        assertThat(requestDTO.getCode()).isEqualTo(responseDTO.getCode());
    }
}
