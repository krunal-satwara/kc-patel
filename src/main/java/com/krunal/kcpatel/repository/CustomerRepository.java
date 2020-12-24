package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByCustomerId(Long customerId);

    List<Customer> findAllByCustomerStatusIsTrue();

    List<Customer> findAllByCustomerStatusIsTrueAndAgentCodeContains(String agentCode);

}
