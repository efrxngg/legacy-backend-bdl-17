package com.bancodellitoral.core.application.create;

import com.bancodellitoral.core.domain.Customer;
import com.bancodellitoral.core.domain.exception.CustomerAlreadyExists;
import com.bancodellitoral.core.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateCustomer {

    private final CustomerRepository customerRepository;

    public void create(Customer customer) {
        log.info("starting");

        // buscar primero si existe
        boolean userExists = false;

        if (userExists) {
            throw new CustomerAlreadyExists();
        }

        customerRepository.save(customer);
        log.info("customer save");

        events();
    }

    /// efectos secundarios
    private void events() {
        log.info("events");
    }
}
