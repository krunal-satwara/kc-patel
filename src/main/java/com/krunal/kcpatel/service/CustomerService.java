package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {

    ResponseEntity<String> customer(Customer customer);

    List<Customer> customers();

    ResponseEntity<String> updateCustomer(Customer customer);

    ResponseEntity<String> deleteCustomer(Long customerId);

    Customer customer(Long customerId);

    ResponseEntity<String> activeDeactiveCustomer(Long customerId);

}
