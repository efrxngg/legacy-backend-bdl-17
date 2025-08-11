package com.bancodellitoral.core.infrastructure.controller;

import com.bancodellitoral.core.application.GreetingCustomer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.CloseableThreadContext;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@Log4j2
public class GetGreetingCustomerRestController {

    private final GreetingCustomer greetingCustomer;
    @Value("${integration.equifax.connecta.url}")
    private String equifaxConnectaUrl;

    @GetMapping("greets")
    public ResponseEntity<String> getGreetingCustomer() {
        IntStream.range(0, 1000).forEach(i -> {
            log.info("{} URL Equifax: {}", i, equifaxConnectaUrl);
        });
        CloseableThreadContext.put("span", "efxngg");
        ThreadContext.clearAll();
        return ok(greetingCustomer.greeting() + equifaxConnectaUrl);
    }


}
