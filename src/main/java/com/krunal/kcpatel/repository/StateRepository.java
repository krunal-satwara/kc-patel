package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.States;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<States, Long> {
    List<States> findAllByCountryId(Long countryId);
}
