package com.company.internationalizationtaticfilesandresources.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DownloadFailedException_DownloadFailedException_cef8ed63d8_Test {

    private DownloadFailedException downloadFailedException;
    
    @BeforeEach
    public void setUp() {
        downloadFailedException = new DownloadFailedException();
    }

    @Test
    public void testDownloadFailedException() {
        String expectedMessage = "DOWNLOAD_FAILED";
        String actualMessage = downloadFailedException.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testDownloadFailedExceptionWithDifferentMessage() {
        String unexpectedMessage = "UPLOAD_FAILED";
        String actualMessage = downloadFailedException.getMessage();
        assertNotEquals(unexpectedMessage, actualMessage);
    }
}
