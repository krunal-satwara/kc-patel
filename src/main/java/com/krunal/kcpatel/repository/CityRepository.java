package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.Cities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<Cities, Long> {
    List<Cities> findAllByStateId(Long stateId);
}
