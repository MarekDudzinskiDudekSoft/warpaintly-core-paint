package com.warpaintly.corepaint.domain.paint.exceptions;

public class PaintNotPresentException extends RuntimeException{

    public PaintNotPresentException(String message) {
        super(message);
    }
}
