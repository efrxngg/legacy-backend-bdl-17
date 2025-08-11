package com.bancodellitoral.core.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GreetingCustomer {
    public String greeting(){
        log.info("Greeting customer");
        return "Hello!";
    }
}
