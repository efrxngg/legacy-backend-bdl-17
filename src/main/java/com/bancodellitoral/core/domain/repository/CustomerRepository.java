package com.bancodellitoral.core.domain.repository;

import com.bancodellitoral.core.domain.Customer;

/// PORT
public interface CustomerRepository {
    void save(Customer customer);
}
