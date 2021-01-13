package com.krunal.kcpatel.serviceImpl;

import com.krunal.kcpatel.entity.Agent;
import com.krunal.kcpatel.entity.ContactPerson;
import com.krunal.kcpatel.entity.Customer;
import com.krunal.kcpatel.repository.AgentRepository;
import com.krunal.kcpatel.repository.ContactPersonRepository;
import com.krunal.kcpatel.repository.CustomerRepository;
import com.krunal.kcpatel.service.CustomerService;
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

    @Autowired
    private ContactPersonRepository contactPersonRepository;

    @Override
    public ResponseEntity<String> customer(Customer customer) {
        try {
            ArrayList<String> agentIdList = new ArrayList<>(Arrays.asList(customer.getAgentId().split(",")));
            String agentCode = "";
            for (String agentId : agentIdList) {
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
            List<Customer> finalCustomerList = new ArrayList<>();
            ArrayList<String> agentList = new ArrayList<>(Arrays.asList(agentCode.split(",")));
            for (String agent : agentList) {
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

    @Override
    public List<Customer> customersUsingMobileNo(String search) {
        try {
            List<Customer> customerList = new ArrayList<>();
            if (search != null && !search.isEmpty()) {
                List<ContactPerson> contactPersonList = contactPersonRepository.findAllByMobileNoContainsOrContactPersonNameContainsOrEmailIdContains(search, search, search);
                if (!contactPersonList.isEmpty() && contactPersonList != null) {
                    for (ContactPerson contactPerson : contactPersonList) {
                        Customer customer = customerRepository.findByCustomerStatusIsTrueAndCustomerId(contactPerson.getCustomer().getCustomerId());
                        customerList.add(customer);
                    }
                }
                List<Customer> customerNameList = customerRepository.findAllByCustomerStatusIsTrueAndCustomerNameContains(search);
                if (customerNameList != null && !customerNameList.isEmpty()) {
                    for (Customer customer : customerNameList) {
                        customerList.add(customer);
                    }
                }
                List<Customer> addressList = customerRepository.findAllByCustomerStatusIsTrueAndAddressContains(search);
                if (addressList != null) {
                    for (Customer customer : addressList) {
                        customerList.add(customer);
                    }
                }
                List<Customer> countryList = customerRepository.findAllByCustomerStatusIsTrueAndCountryContains(search);
                if (countryList != null) {
                    for (Customer customer : countryList) {
                        customerList.add(customer);
                    }
                }
                List<Customer> stateList = customerRepository.findAllByCustomerStatusIsTrueAndStateContains(search);
                if (stateList != null) {
                    for (Customer customer : stateList) {
                        customerList.add(customer);
                    }
                }
                List<Customer> cityList = customerRepository.findAllByCustomerStatusIsTrueAndCityContains(search);
                if (cityList != null) {
                    for (Customer customer : cityList) {
                        customerList.add(customer);
                    }
                }
                List<Customer> websiteList = customerRepository.findAllByCustomerStatusIsTrueAndWebsiteContains(search);
                if (websiteList != null) {
                    for (Customer customer : websiteList) {
                        customerList.add(customer);
                    }
                }
                List<Customer> pinCodeList = customerRepository.findAllByCustomerStatusIsTrueAndPinCodeContains(search);
                if (pinCodeList != null) {
                    for (Customer customer : pinCodeList) {
                        customerList.add(customer);
                    }
                }
                List<Customer> agentCodeList = customerRepository.findAllByCustomerStatusIsTrueAndAgentCodeContains(search);
                if (agentCodeList != null) {
                    for (Customer customer : agentCodeList) {
                        customerList.add(customer);
                    }
                }
                List<Customer> groupNoList = customerRepository.findAllByCustomerStatusIsTrueAndGroupNoIs(search);
                if (groupNoList != null) {
                    for (Customer customer : groupNoList) {
                        customerList.add(customer);
                    }
                }

            }
            return customerList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long generateCustomerGroupNo() {
        Long groupNo = customerRepository.groupNoGenerate();
        if (groupNo == null) {
            groupNo = 1L;
        } else {
            groupNo += 1L;
        }
        return groupNo;
    }

}
