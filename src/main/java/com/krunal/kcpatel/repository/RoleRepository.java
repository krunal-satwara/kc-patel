package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleId(Long roleId);

    List<Role> findAllByStatusIsFalse();
}
