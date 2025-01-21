package com.app.service_log.controller;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LogController {

    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    /**
     * Logs the details of an incoming request.
     * <p>
     * Accepts a generic request object, logs its details along with the current timestamp,
     * and responds with a 200 OK status.
     *
     * @param request the incoming request object to be logged
     * @return a {@link ResponseEntity} indicating that the request was successfully logged
     */
    @PostMapping("/log")
    public ResponseEntity<Void> logRequest(@RequestBody Object request) {
        logger.info("Received request: {} and Current Time:{}", request,Instant.now());
        return ResponseEntity.ok().build();
    }
}
