package com.company.internationalizationtaticfilesandresources.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IFileStorageService_init_0ef02243a9_Test {

    @InjectMocks
    FileStorageService fileStorageService = new FileStorageService();

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testInit_success() throws IOException {
        Path directory = tempDir.resolve("test");
        Files.createDirectories(directory);
        fileStorageService.init(directory);
        assertTrue(Files.exists(directory));
    }

    @Test
    void testInit_throwsException() {
        Path directory = tempDir.resolve("test/test");
        assertThrows(RuntimeException.class, () -> fileStorageService.init(directory));
    }
}
