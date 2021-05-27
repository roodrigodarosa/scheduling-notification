package com.luizalabs.notification.service.exception;

public class SchedulingBadRequestException extends SchedulingException {

    public static final int STATUS = 400;

    public SchedulingBadRequestException(String message) {
        super(message);
    }

    public int getStatus() {
        return STATUS;
    }
}