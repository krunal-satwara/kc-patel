package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.States;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<States, Long> {
    List<States> findAllByCountryId(Long countryId);
}
