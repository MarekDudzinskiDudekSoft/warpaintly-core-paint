package com.warpaintly.corepaint.domain.paint;

import com.warpaintly.corepaint.domain.paint.exceptions.PaintDomainOperationException;

import java.util.Arrays;

import static com.warpaintly.corepaint.domain.paint.exceptions.PaintDomainOperationException.PaintDomainOperationErrorCode.PAINT_BRAND_INVALID;

public enum PaintBrand {

    CITADEL,
    VALLEJO,
    AK_INTERACTIVE;

    public static PaintBrand from(String name) {
        return Arrays.stream(values())
                .filter(value -> value.toString().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new PaintDomainOperationException(PAINT_BRAND_INVALID, "Paint brand is invalid! "));
    }
}
