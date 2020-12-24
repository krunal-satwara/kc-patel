package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.Agent;
import com.krunal.kcpatel.entity.Customer;
import com.krunal.kcpatel.repository.AgentRepository;
import com.krunal.kcpatel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public ResponseEntity<String> customer(Customer customer) {
        try {
            ArrayList<String> agentIdList = new ArrayList<>(Arrays.asList(customer.getAgentId().split(",")));
            String agentCode = "";
            for (String agentId: agentIdList) {
                Agent agent = agentRepository.findByAgentId(Long.parseLong(agentId));
                agentCode += agent.getAgentCode() + ", ";
            }
            customer.setAgentCode(agentCode);
            customerRepository.save(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public List<Customer> customers() {
        try {
            return customerRepository.findAllByCustomerStatusIsTrue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> customers(String agentCode) {
        try {
            System.out.println("Agent Code ="+agentCode);
            List<Customer> finalCustomerList = new ArrayList<>();
            ArrayList<String> agentList = new ArrayList<>(Arrays.asList(agentCode.split(",")));
            for (String agent: agentList) {
                 List<Customer> customerList = customerRepository.findAllByCustomerStatusIsTrueAndAgentCodeContains(agent);
                 finalCustomerList.addAll(customerList);
            }
            return finalCustomerList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseEntity<String> updateCustomer(Customer customer) {
        try {
            customerRepository.save(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> deleteCustomer(Long customerId) {
        try {
            Customer customer = customerRepository.findByCustomerId(customerId);
            customer.setCustomerStatus(false);
            customerRepository.save(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public Customer customer(Long customerId) {
        try {
            return customerRepository.findByCustomerId(customerId);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseEntity<String> activeDeactiveCustomer(Long customerId) {
        try {
            Customer customer = customerRepository.findByCustomerId(customerId);
            if (customer.isStatus() == false) {
                customer.setStatus(true);
            } else {
                customer.setStatus(false);
            }
            customerRepository.save(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
