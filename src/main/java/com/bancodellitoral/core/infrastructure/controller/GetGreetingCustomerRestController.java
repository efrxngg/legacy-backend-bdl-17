package com.bancodellitoral.core.infrastructure.controller;

import com.bancodellitoral.core.application.GreetingCustomer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@Slf4j
public class GetGreetingCustomerRestController {

    private final GreetingCustomer greetingCustomer;
    @Value("${integration.equifax.connecta.url}")
    private String equifaxConnectaUrl;

    @GetMapping("greets")
    public ResponseEntity<String> getGreetingCustomer() {
        IntStream.range(0, 1000).forEach(i -> {
            log.info("{} URL Equifax: {}", i, equifaxConnectaUrl);
        });
        return ok(greetingCustomer.greeting() + equifaxConnectaUrl);
    }


}
