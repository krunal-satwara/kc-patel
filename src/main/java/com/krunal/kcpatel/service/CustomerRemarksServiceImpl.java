package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.CustomerRemarks;
import com.krunal.kcpatel.entity.User;
import com.krunal.kcpatel.repository.CustomerRemarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerRemarksServiceImpl implements CustomerRemarksService {

    @Autowired
    private CustomerRemarksRepository customerRemarksRepository;

    @Autowired private UserService userService;

    @Override
    public ResponseEntity<String> saveCustomerRemarks(CustomerRemarks customerRemarks) {
        try {
            User user = userService.getUser(customerRemarks.getUserId());
            customerRemarks.setUserName(user.getFirstName());
            customerRemarksRepository.save(customerRemarks);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public List<CustomerRemarks> customerRemarksList(Long customerId) {
        try {
            return customerRemarksRepository.findAllByStatusIsTrueAndCustomerId(customerId);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseEntity<String> updateCustomerRemarks(CustomerRemarks customerRemarks) {
        try {
            customerRemarksRepository.save(customerRemarks);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> deleteCustomerRemarks(Long customerRemarksId) {
        try {
            CustomerRemarks customerRemarks = customerRemarksRepository.findByCustomerRemarksId(customerRemarksId);
            customerRemarks.setStatus(false);
            customerRemarksRepository.save(customerRemarks);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public CustomerRemarks customerRemarks(Long customerRemarksId) {
        try {
            return customerRemarksRepository.findByCustomerRemarksId(customerRemarksId);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
