package com.app.service_shuffle.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.service_shuffle.model.ShuffleRequest;

@FeignClient(name = "service-log", url = "${service.log.url}")
public interface ServiceLogClient {

    @PostMapping("/log")
    void logRequest(@RequestBody ShuffleRequest request);
}