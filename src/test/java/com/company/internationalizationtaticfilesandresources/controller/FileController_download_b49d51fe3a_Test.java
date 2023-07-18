package com.company.internationalizationtaticfilesandresources.controller;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.service.FileStorageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FileController_download_b49d51fe3a_Test {

    @InjectMocks
    FileController fileController;

    @Mock
    FileStorageService fileStorageService;

    @Mock
    Resource resource;

    @BeforeEach
    public void setUp() {
        when(resource.getFilename()).thenReturn("testFile.txt");
    }

    @Test
    public void testDownloadSuccess() {
        when(fileStorageService.download("testFile.txt")).thenReturn(resource);

        ResponseEntity<Resource> responseEntity = fileController.download("testFile.txt");

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(MediaType.MULTIPART_FORM_DATA, responseEntity.getHeaders().getContentType());
        assertEquals("attachment: fileName =\"testFile.txt\"", responseEntity.getHeaders().getFirst(HttpHeaders.CONTENT_DISPOSITION));
        assertEquals(resource, responseEntity.getBody());
    }

    @Test
    public void testDownloadFailure() {
        when(fileStorageService.download("nonExistentFile.txt")).thenReturn(null);

        ResponseEntity<ResponseMessage> responseEntity = fileController.download("nonExistentFile.txt");

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("File not found: nonExistentFile.txt", responseEntity.getBody().getMessage());
    }
}
