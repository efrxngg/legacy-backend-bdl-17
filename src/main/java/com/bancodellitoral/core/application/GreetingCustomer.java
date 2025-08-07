package com.bancodellitoral.core.application;

import org.springframework.stereotype.Service;

@Service
public class GreetingCustomer {
    public String greeting(){
        return "Hello!";
    }
}
