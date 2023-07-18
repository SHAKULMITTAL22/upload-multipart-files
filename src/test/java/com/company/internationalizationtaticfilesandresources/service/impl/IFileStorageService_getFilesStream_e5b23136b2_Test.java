package com.company.internationalizationtaticfilesandresources.service.impl;

import com.company.internationalizationtaticfilesandresources.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class IFileStorageService_getFilesStream_e5b23136b2_Test {

    @TempDir
    Path tempDir;

    @Test
    public void testGetFilesStream_Success() throws IOException {
        Path testFile = Files.createFile(tempDir.resolve("test.txt"));
        Stream<Path> filesStream = Files.walk(tempDir);
        assertTrue(filesStream.anyMatch(path -> path.equals(testFile)));
    }

    @Test
    public void testGetFilesStream_NotFoundException() {
        Path nonExistentPath = tempDir.resolve("nonexistent");
        assertThrows(IOException.class, () -> Files.walk(nonExistentPath));
    }

    @Test
    public void testGetFilesStream_IOException() {
        assertThrows(IOException.class, () -> Files.walk(null));
    }
}
