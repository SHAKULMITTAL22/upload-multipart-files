package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.enums.ExceptionEnum;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalExceptionHandler_uploadHandler_bf5af06614_Test {

    @Test
    public void testUploadHandlerSuccess() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        ResponseEntity<ResponseMessage> response = handler.uploadHandler();

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(ExceptionEnum.UPLOAD_FAILED.name(), response.getBody().getMessage().toString());
    }

    @Test
    public void testUploadHandlerFailure() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        ResponseEntity<ResponseMessage> response = handler.uploadHandler();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Success", response.getBody().getMessage().toString());
    }
}
