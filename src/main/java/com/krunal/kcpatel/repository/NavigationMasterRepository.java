package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.NavigationMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NavigationMasterRepository extends JpaRepository<NavigationMaster, Long> {
}
