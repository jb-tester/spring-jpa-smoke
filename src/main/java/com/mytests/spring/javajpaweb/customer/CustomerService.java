package com.mytests.spring.javajpaweb.customer;

import org.springframework.data.auditing.AuditingHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AuditingHandler auditingHandler;


    public CustomerService(CustomerRepository customerRepository,
                           AuditingHandler auditingHandler) {
        this.customerRepository = customerRepository;
        this.auditingHandler = auditingHandler;
    }

    public Customer createCustomerWithAuditingHandler(String name, String email) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setAuditingMetadata(new AuditMetadata());

        auditingHandler.markCreated(customer);

        return customerRepository.save(customer);
    }

    public List<String> updateCustomersEmail(String oldEmailDomain, String newEmailDomain) {
        var customers = customerRepository.findAllByEmailIsContainingIgnoreCase(oldEmailDomain);
        var entries = new ArrayList<String>();
        for (Customer customer : customers) {
            var id = customer.getId();
            var oldEmail = customer.getEmail();
            var newCustomer = customerRepository.findById(id).orElseThrow();
            newCustomer.setEmail(oldEmail.replace(oldEmailDomain, newEmailDomain));
            auditingHandler.markModified(newCustomer);
            var rez = customerRepository.save(newCustomer);
            entries.add(rez.toString());
        }
        return entries;
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer createAndAuditManually(String name, String email) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setAuditingMetadata(new AuditMetadata());
        Customer audited = auditingHandler.markCreated(customer);
        return customerRepository.save(audited);
    }
}
