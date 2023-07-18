package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.exception.DeleteFailedException;
import com.company.internationalizationtaticfilesandresources.exception.DownloadFailedException;
import com.company.internationalizationtaticfilesandresources.exception.NotFoundException;
import com.company.internationalizationtaticfilesandresources.exception.UploadFailedException;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.junit.Test;
import org.junit.Assert;
import org.springframework.http.HttpStatus;

public class GlobalExceptionHandler_handle_a6daf70424_Test {

    @Test
    public void testHandleSuccess() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        ResponseEntity<ResponseMessage> response = handler.handle(new FileSizeLimitExceededException("", 1, 1));
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        Assert.assertEquals("File size to large!", response.getBody().getMessage().toString());
    }

    @Test
    public void testHandleFailure() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        ResponseEntity<ResponseMessage> response = handler.handle(new Exception());
        Assert.assertNotEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertNotEquals("Success", response.getBody().getMessage().toString());
    }
}
