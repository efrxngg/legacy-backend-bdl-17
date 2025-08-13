package com.bancodellitoral.core.infrastructure.repository;

import com.bancodellitoral.core.domain.Customer;
import com.bancodellitoral.core.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

// ADAPTER
@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private final ConcurrentHashMap<String, Customer> customers = new ConcurrentHashMap<>();

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }
}
