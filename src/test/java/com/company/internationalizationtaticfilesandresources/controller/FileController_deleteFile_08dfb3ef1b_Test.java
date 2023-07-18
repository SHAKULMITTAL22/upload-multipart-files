package com.company.internationalizationtaticfilesandresources.controller;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.service.FileStorageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FileController_deleteFile_08dfb3ef1b_Test {

    @InjectMocks
    FileController fileController;

    @Mock
    FileStorageService fileStorageService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeleteFileSuccess() {
        String fileName = "testFile.txt";
        ResponseMessage responseMessage = new ResponseMessage("File deleted successfully");
        when(fileStorageService.delete(fileName)).thenReturn(responseMessage);

        ResponseEntity<ResponseMessage> response = fileController.deleteFile(fileName);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(responseMessage, response.getBody());
    }

    @Test
    public void testDeleteFileFailure() {
        String fileName = "nonExistentFile.txt";
        ResponseMessage responseMessage = new ResponseMessage("File not found");
        when(fileStorageService.delete(fileName)).thenReturn(responseMessage);

        ResponseEntity<ResponseMessage> response = fileController.deleteFile(fileName);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(responseMessage, response.getBody());
    }
}
