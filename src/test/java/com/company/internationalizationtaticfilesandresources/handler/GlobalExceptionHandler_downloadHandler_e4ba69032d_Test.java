package com.company.internationalizationtaticfilesandresources.handler;

import com.company.internationalizationtaticfilesandresources.dto.ResponseMessage;
import com.company.internationalizationtaticfilesandresources.exception.DownloadFailedException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class GlobalExceptionHandler_downloadHandler_e4ba69032d_Test {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDownloadHandler() {
        ResponseEntity<ResponseMessage> expectedResponse = ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseMessage(new StringBuilder("DOWNLOAD_FAILED").toString()));

        ResponseEntity<ResponseMessage> actualResponse = globalExceptionHandler.downloadHandler();

        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getBody().getMessage(), actualResponse.getBody().getMessage());
    }

    @Test(expected = DownloadFailedException.class)
    public void testDownloadHandlerException() {
        throw new DownloadFailedException("Download Failed");
    }
}
