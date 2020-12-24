package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.UserNavigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserNavigationRepository extends JpaRepository<UserNavigation, Long> {
    List<UserNavigation> findAllByUserId(Long userId);

    ResponseEntity<String> deleteByUserId(Long userId);

}
