package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.Role;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoleService {

    ResponseEntity<String> saveRole(Role role);

    ResponseEntity<String> deleteRole(Long roleId);

    Role getRole(Long roleId);

    List<Role> roles();
}
