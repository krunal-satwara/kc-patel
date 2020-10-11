package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserId(Long userId);

    List<User> findAllByStatusIsTrueAndDeleteStatusIsFalse();

    List<User> findAllByStatusIsFalseAndDeleteStatusIsFalse();

    List<User> findAllByDeleteStatusIsTrue();

    User findByUserEmail(String userEmail);
}
