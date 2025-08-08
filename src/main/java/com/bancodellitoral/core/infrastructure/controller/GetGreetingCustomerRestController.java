package com.bancodellitoral.core.infrastructure.controller;

import com.bancodellitoral.core.application.GreetingCustomer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@Slf4j
public class GetGreetingCustomerRestController {

    private final GreetingCustomer greetingCustomer;

    @GetMapping("greets")
    public ResponseEntity<String> getGreetingCustomer() {
        log.info("user");
        return ok(greetingCustomer.greeting());
    }


}
