package com.mytests.spring.javajpaweb.customer;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.UUID;


public interface CustomerRepository extends ListCrudRepository<Customer, UUID> {
    List<Customer> findAllByEmailIsContainingIgnoreCase(String email);
}
