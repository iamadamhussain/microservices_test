package com.app.service_shuffle.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import com.app.service_shuffle.config.ServiceLogClient;
import com.app.service_shuffle.model.ShuffleRequest;

public class ShuffleServiceTest {

    @Mock
    private ServiceLogClient serviceLogClient;

    @Mock
    private Logger logger;

    @InjectMocks
    private ShuffleService shuffleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetShuffledArray() {
        int n = 5;
        List<Integer> shuffledArray = shuffleService.getShuffledArray(n);

        // Verify the shuffled array contains all elements from 1 to n
        assertEquals(n, shuffledArray.size());
        for (int i = 1; i <= n; i++) {
            assertEquals(true, shuffledArray.contains(i));
        }
    }

    @Test
    public void testLogRequestAsync() {
        ShuffleRequest request = new ShuffleRequest();
        request.setNumber(2);

        shuffleService.logRequestAsync(request);

        // Verify that the logRequest method of serviceLogClient is called
        verify(serviceLogClient).logRequest(request);
    }

    @Test
    public void testLogRequestAsync_ExceptionHandling() {
        ShuffleRequest request = new ShuffleRequest();
        request.setNumber(2);

        // Simulate an exception in the ServiceLogClient
        doThrow(new RuntimeException("Mock exception")).when(serviceLogClient).logRequest(request);

        shuffleService.logRequestAsync(request);

       
    }
}
