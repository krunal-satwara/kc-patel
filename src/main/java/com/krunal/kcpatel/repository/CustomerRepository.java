package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByCustomerId(Long customerId);

    Customer findByCustomerStatusIsTrueAndCustomerId(Long customerId);

    List<Customer> findAllByCustomerStatusIsTrue();

    List<Customer> findAllByCustomerStatusIsTrueAndAgentCodeContains(String agentCode);

    List<Customer> findAllByCustomerStatusIsTrueAndCustomerNameContains(String customerName);

    List<Customer> findAllByCustomerStatusIsTrueAndAddressContains(String address);

    List<Customer> findAllByCustomerStatusIsTrueAndCountryContains(String country);

    List<Customer> findAllByCustomerStatusIsTrueAndStateContains(String state);

    List<Customer> findAllByCustomerStatusIsTrueAndCityContains(String city);

    List<Customer> findAllByCustomerStatusIsTrueAndPinCodeContains(String pinCode);

    List<Customer> findAllByCustomerStatusIsTrueAndWebsiteContains(String website);

    List<Customer> findAllByCustomerStatusIsTrueAndGroupNoIs(String groupNo);

    @Query(value = "SELECT max(`group_no`) from kcpatel.`customer`",nativeQuery = true)
    Long groupNoGenerate();

}
