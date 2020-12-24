package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Countries, Long> {
}
