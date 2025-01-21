package com.app.service_shuffle.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.app.service_shuffle.config.ServiceLogClient;
import com.app.service_shuffle.model.ShuffleRequest;

@Service
public class ShuffleService {
private static Logger logger=LoggerFactory.getLogger(ShuffleService.class);
    private final ServiceLogClient serviceLogClient;

    public ShuffleService(ServiceLogClient serviceLogClient) {
        this.serviceLogClient = serviceLogClient;
    }
    /**
     * Generates a shuffled list of integers from 1 to the specified number.
     *
     * @param n the maximum number in the range to shuffle
     * @return a shuffled {@link List} of integers from 1 to {@code n}
     */
    public List<Integer> getShuffledArray(int n) {
        List<Integer> numbers = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers;
    }
    
    
    /**
     * Logs the shuffle request asynchronously.
     * <p>
     * Attempts to log the shuffle request using the {@link ServiceLogClient}. If an exception occurs during the logging process,
     * it is caught and logged.
     *
     * @param request the shuffle request to be logged
     */
    @Async
    public void logRequestAsync(ShuffleRequest request) {
        try {
        	logger.info("logRequestAsync  :{}",request.getNumber());
            serviceLogClient.logRequest(request);
        } catch (Exception e) {
            // Handle logging error
            logger.error("Failed to log request: {}",e.getMessage());
        }
    }
}
