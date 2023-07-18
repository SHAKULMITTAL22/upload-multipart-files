package com.company.internationalizationtaticfilesandresources.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UploadFailedException_UploadFailedException_78b326900b_Test {

    private UploadFailedException exception;

    @BeforeEach
    public void setUp() {
        exception = new UploadFailedException();
    }

    @Test
    public void testUploadFailedException() {
        assertEquals("Upload Failed", exception.getMessage());
    }

    @Test
    public void testUploadFailedExceptionWithDifferentException() {
        exception = new UploadFailedException("Database Error");
        assertEquals("Database Error", exception.getMessage());
    }
}
