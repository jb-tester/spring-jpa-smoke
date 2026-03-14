package com.mytests.spring.javajpaweb.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/add1/{name}")
    public String add1(@PathVariable("name") String name) {
        String email = name + "@gmail.com";
        var customer = customerService.createCustomerWithAuditingHandler(name, email);
        return "created " + customer.toString();
    }

    @GetMapping("/update/{email}")
    public List<String> update(@PathVariable("email") String email) {
        var updated = customerService.updateCustomersEmail(email,"updated");
        return updated;
    }

    @GetMapping("/all")
    public List<Customer> findAll(){
        return customerService.findAllCustomers();
    }

    @GetMapping("/add2/{name}")
    public String add2(@PathVariable("name") String name) {
        String email = name + "@gmail.com";
        var customer = customerService.createAndAuditManually(name, email);
        return "created " + customer.toString();
    }
}
