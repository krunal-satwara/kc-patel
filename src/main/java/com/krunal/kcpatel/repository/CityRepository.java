package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.Cities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CityRepository extends JpaRepository<Cities, Long> {
    List<Cities> findAllByStateId(Long stateId);
}
