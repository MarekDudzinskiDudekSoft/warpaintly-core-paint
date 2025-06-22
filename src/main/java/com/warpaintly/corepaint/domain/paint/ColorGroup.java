package com.warpaintly.corepaint.domain.paint;

import com.warpaintly.corepaint.domain.paint.exceptions.PaintDomainOperationException;

import java.util.Arrays;

import static com.warpaintly.corepaint.domain.paint.exceptions.PaintDomainOperationException.PaintDomainOperationErrorCode.PAINT_COLOR_GROUP_INVALID;

public enum ColorGroup {

    WHITE,
    YELLOW,
    ORANGE,
    RED,
    PURPLE,
    BLUE,
    GREEN,
    BLACK,
    BROWN;

    public static ColorGroup from(String name) {
        return Arrays.stream(values())
                .filter(value -> value.toString().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new PaintDomainOperationException(PAINT_COLOR_GROUP_INVALID, "Paint color group is invalid! "));
    }

}
