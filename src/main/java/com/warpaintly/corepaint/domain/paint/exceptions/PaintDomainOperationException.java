package com.warpaintly.corepaint.domain.paint.exceptions;


import com.warpaintly.corepaint.shared.exceptions.DomainOperationException;

public class PaintDomainOperationException extends DomainOperationException {

    private final PaintDomainOperationErrorCode errorCode;

    public PaintDomainOperationException(PaintDomainOperationErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    @Override
    public String getErrorCode() {
        return errorCode.toString();
    }

    public enum PaintDomainOperationErrorCode {
        PAINT_NOT_FOUND,
        PAINT_BRAND_INVALID,
        PAINT_COLOR_GROUP_INVALID,
        PAINT_TYPE_INVALID,
    }

}