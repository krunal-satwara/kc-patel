package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.UserAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAgentRepository extends JpaRepository<UserAgent, Long> {
    List<UserAgent> findAllByUserId(Long userId);
}
