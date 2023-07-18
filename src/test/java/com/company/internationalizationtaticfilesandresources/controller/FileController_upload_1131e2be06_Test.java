package com.company.internationalizationtaticfilesandresources.controller;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.service.FileStorageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FileController_upload_1131e2be06_Test {

    @Mock
    private FileStorageService fileStorageService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpload_success() {
        MultipartFile file = new MockMultipartFile("data", "filename.txt", "text/plain", "some xml".getBytes());
        ResponseMessage responseMessage = new ResponseMessage(new StringBuilder("Upload Successful"));
        when(fileStorageService.upload(file)).thenReturn(responseMessage);

        ResponseEntity<ResponseMessage> responseEntity = new FileController(fileStorageService).upload(file);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Upload Successful", responseEntity.getBody().getMessage());
    }

    @Test
    public void testUpload_failure() {
        MultipartFile file = new MockMultipartFile("data", "filename.txt", "text/plain", "some xml".getBytes());
        ResponseMessage responseMessage = new ResponseMessage(new StringBuilder("Upload Failed"));
        when(fileStorageService.upload(file)).thenReturn(responseMessage);

        ResponseEntity<ResponseMessage> responseEntity = new FileController(fileStorageService).upload(file);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Upload Failed", responseEntity.getBody().getMessage());
    }
}
