package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.CustomerRemarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRemarksRepository extends JpaRepository<CustomerRemarks, Long> {

    List<CustomerRemarks> findAllByStatusIsTrue();

    CustomerRemarks findByCustomerRemarksId(Long customerRemarksId);

}
