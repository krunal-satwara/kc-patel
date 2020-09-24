package com.krunal.kcpatel.controller;

import com.krunal.kcpatel.entity.Role;
import com.krunal.kcpatel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/save")
    public ResponseEntity<String> saveRole(@RequestBody Role role) {
        return roleService.saveRole(role);
    }

    @GetMapping("/{roleId}")
    public Role getRole(@PathVariable("roleId") Long roleId) {
        return roleService.getRole(roleId);
    }

    @GetMapping("/roles")
    public List<Role> roles() {
        return roleService.roles();
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<String> deleteRole(@PathVariable("roleId") Long roleId) {
        return roleService.deleteRole(roleId);
    }
}
