package com.bancodellitoral.core.infrastructure.rest;

import com.bancodellitoral.core.application.create.CreateCustomer;
import com.bancodellitoral.core.domain.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.created;

@RestController
@RequiredArgsConstructor
@Slf4j
public class GetGreetingCustomerRestController {

    private final CreateCustomer createCustomer;

    @PostMapping("greets")
    public ResponseEntity<Void> getCreateCustomer(@RequestBody Customer customer) {
        MDC.put("traceId", UUID.randomUUID().toString());
        log.info("handle getCreateCustomer");
        createCustomer.create(customer);
        return created(URI.create(customer.getId())).build();
    }


}
