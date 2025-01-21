package com.app.service_shuffle.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service_shuffle.model.ShuffleRequest;
import com.app.service_shuffle.model.ShuffleResponse;
import com.app.service_shuffle.service.ShuffleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ShuffleController {
	private static Logger logger=LoggerFactory.getLogger(ShuffleController.class);

    private final ShuffleService shuffleService;

    public ShuffleController(ShuffleService shuffleService) {
        this.shuffleService = shuffleService;
    }
    /**
     * Shuffles a given array of numbers.
     * 
     * Accepts a request containing numbers to shuffle, performs the shuffling operation, logs the request asynchronously,
     * and returns the shuffled array along with a success message.
     *
     * @param request the request containing the numbers to shuffle
     * @return a {@link ResponseEntity} containing a {@link ShuffleResponse} with the shuffled numbers and a success message
     */
    @PostMapping("/shuffle")
    public ResponseEntity<ShuffleResponse> shuffleNumbers(@Valid @RequestBody ShuffleRequest request) {
    	logger.info("shuffleNumbers {}",request.getNumber());
        List<Integer> shuffledNumbers = shuffleService.getShuffledArray(request.getNumber());
        shuffleService.logRequestAsync(request);
        return ResponseEntity.ok(new ShuffleResponse("Success", shuffledNumbers));
    }
}
