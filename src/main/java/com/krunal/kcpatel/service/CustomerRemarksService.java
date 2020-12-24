package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.CustomerRemarks;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerRemarksService {

    ResponseEntity<String> saveCustomerRemarks(CustomerRemarks customerRemarks);

    List<CustomerRemarks> customerRemarksList(Long customerId);

    ResponseEntity<String> updateCustomerRemarks(CustomerRemarks customerRemarks);

    ResponseEntity<String> deleteCustomerRemarks(Long customerRemarksId);

    CustomerRemarks customerRemarks(Long customerRemarksId);

}
