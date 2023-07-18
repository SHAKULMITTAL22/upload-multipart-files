package com.company.internationalizationtaticfilesandresources.service.impl;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.exception.UploadFailedException;
import com.company.internationalizationtaticfilesandresources.service.FileStorageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IFileStorageService_upload_3b48639aa2_Test {

    private FileStorageService fileStorageService;

    @Mock
    private Path ROOT;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        fileStorageService = new FileStorageServiceImpl(ROOT);
    }

    @Test
    public void testUploadSuccess() {
        MultipartFile file = new MockMultipartFile("file", "hello.txt", "text/plain", "Hello, World!".getBytes());
        when(ROOT.resolve(any())).thenReturn(Paths.get("hello.txt"));

        ResponseMessage responseMessage = fileStorageService.upload(file);

        assertEquals("FILE_UPLOAD_IS_SUCCESS", responseMessage.getMessage().toString());
        verify(ROOT, times(1)).resolve(any());
    }

    @Test
    public void testUploadFailure() {
        MultipartFile file = new MockMultipartFile("file", "hello.txt", "text/plain", "Hello, World!".getBytes());
        when(ROOT.resolve(any())).thenReturn(Paths.get("hello.txt"));
        // doThrow(IOException.class).when(Files.copy(any(), any()));

        assertThrows(UploadFailedException.class, () -> fileStorageService.upload(file));
        verify(ROOT, times(1)).resolve(any());
    }
}
