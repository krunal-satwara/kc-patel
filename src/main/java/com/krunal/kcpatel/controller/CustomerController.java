package com.krunal.kcpatel.controller;

import com.krunal.kcpatel.entity.Customer;
import com.krunal.kcpatel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<String> customer(@RequestBody Customer customer) throws IOException {
        return customerService.customer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> customers() {
        return customerService.customers();
    }

    @GetMapping("/customer/{customerId}")
    public Customer customer(@PathVariable Long customerId) {
        return customerService.customer(customerId);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId) {
        return customerService.deleteCustomer(customerId);
    }

    @PostMapping("/customerStatus/{customerId}")
    public ResponseEntity<String> activeDeactiveCustomer(@PathVariable Long customerId) {
        return customerService.activeDeactiveCustomer(customerId);
    }
}
