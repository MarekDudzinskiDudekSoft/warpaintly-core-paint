package com.warpaintly.corepaint.domain.paint;

import com.warpaintly.corepaint.domain.paint.exceptions.PaintDomainOperationException;

import java.util.Arrays;

import static com.warpaintly.corepaint.domain.paint.exceptions.PaintDomainOperationException.PaintDomainOperationErrorCode.PAINT_TYPE_INVALID;

public enum PaintType {

    BASE,
    LAYER,
    SHADE,
    METALLIC,
    TECHNICAL;

    public static PaintType from(String name) {
        return Arrays.stream(values())
                .filter(value -> value.toString().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new PaintDomainOperationException(PAINT_TYPE_INVALID, "Paint type is invalid! "));
    }

}
