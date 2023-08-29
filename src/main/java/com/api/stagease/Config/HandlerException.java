package com.api.stagease.Config;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class HandlerException extends RuntimeException {
    public HandlerException(String message) {
        super(message);
    }
}
