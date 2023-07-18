package com.company.internationalizationtaticfilesandresources.service.impl;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.exception.DeleteFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IFileStorageService_delete_582328788e_Test {

    @Mock
    private Path ROOT;

    @InjectMocks
    private FileStorageService fileStorageService;

    @BeforeEach
    public void setUp() {
        ROOT = Paths.get("src/test/resources");
    }

    @Test
    public void testDeleteWhenFileExists() {
        String fileName = "test.txt";

        when(ROOT.resolve(fileName)).thenReturn(ROOT.resolve(fileName));
        // TODO: Ensure the file exists in the test resources folder

        ResponseMessage responseMessage = fileStorageService.delete(fileName);

        verify(ROOT, times(1)).resolve(fileName);
        assertEquals("DELETE_SUCCESSFULLY", responseMessage.getMessage().toString());
    }

    @Test
    public void testDeleteWhenFileDoesNotExist() {
        String fileName = "nonexistent.txt";

        when(ROOT.resolve(fileName)).thenReturn(ROOT.resolve(fileName));

        assertThrows(DeleteFailedException.class, () -> {
            fileStorageService.delete(fileName);
        });

        verify(ROOT, times(1)).resolve(fileName);
    }
}
