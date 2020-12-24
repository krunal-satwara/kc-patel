package com.krunal.kcpatel.controller;


import com.krunal.kcpatel.entity.CustomerRemarks;
import com.krunal.kcpatel.service.CustomerRemarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerRemarks")
public class CustomerRemarksController {

    @Autowired private CustomerRemarksService customerRemarksService;

    @PostMapping("/save")
    public ResponseEntity<String> saveCustomerRemarks(@RequestBody CustomerRemarks customerRemarks) {
        return customerRemarksService.saveCustomerRemarks(customerRemarks);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCustomerRemarks(@RequestBody CustomerRemarks customerRemarks) {
        return customerRemarksService.updateCustomerRemarks(customerRemarks);
    }

    @GetMapping("/{customerRemarksId}")
    public CustomerRemarks customerRemarks(@PathVariable("customerRemarksId") Long customerRemarksId) {
        return customerRemarksService.customerRemarks(customerRemarksId);
    }

    @GetMapping("/customerRemarksList/{customerId}")
    public List<CustomerRemarks> customerRemarksList(@PathVariable("customerId") Long customerId) {
        return customerRemarksService.customerRemarksList(customerId);
    }

    @DeleteMapping("/{customerRemarksId}")
    public ResponseEntity<String> deleteCustomerRemarks(@PathVariable("customerRemarksId") Long customerRemarksId) {
        return customerRemarksService.deleteCustomerRemarks(customerRemarksId);
    }

}
