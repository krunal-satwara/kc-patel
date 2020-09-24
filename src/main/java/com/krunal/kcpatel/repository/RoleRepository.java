package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleId(Long roleId);

    List<Role> findAllByStatusIsFalse();
}
