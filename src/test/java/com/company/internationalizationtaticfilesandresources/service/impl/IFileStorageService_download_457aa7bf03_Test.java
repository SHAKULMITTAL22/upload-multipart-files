package com.company.internationalizationtaticfilesandresources.service.impl;

import com.company.internationalizationtaticfilesandresources.exception.DownloadFailedException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IFileStorageService_download_457aa7bf03_Test {

    private FileStorageService fileStorageService;

    @Mock
    private Resource resource;

    @Before
    public void setUp() {
        fileStorageService = new FileStorageService();
    }

    @Test
    public void testDownloadSuccess() throws IOException {
        String fileName = "testFile.txt";
        Path file = Paths.get(fileName);
        Resource expectedResource = new UrlResource(file.toUri());

        when(resource.exists()).thenReturn(true);
        when(resource.isReadable()).thenReturn(true);
        when(resource.getInputStream()).thenReturn(expectedResource.getInputStream());

        Resource actualResource = fileStorageService.download(fileName);

        assertNotNull(actualResource);
        assertEquals(expectedResource, actualResource);
    }

    @Test(expected = DownloadFailedException.class)
    public void testDownloadFailure() {
        String fileName = "nonExistentFile.txt";
        fileStorageService.download(fileName);
    }
}
