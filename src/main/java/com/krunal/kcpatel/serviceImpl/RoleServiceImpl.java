package com.krunal.kcpatel.serviceImpl;

import com.krunal.kcpatel.entity.Role;
import com.krunal.kcpatel.repository.RoleRepository;
import com.krunal.kcpatel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public ResponseEntity<String> saveRole(Role role) {
        try {
            roleRepository.save(role);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> deleteRole(Long roleId) {
        try {
            Role role = roleRepository.findByRoleId(roleId);
            role.setStatus(true);
            roleRepository.save(role);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public Role getRole(Long roleId) {
        try {
            return roleRepository.findByRoleId(roleId);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Role> roles() {
        try {
            return roleRepository.findAllByStatusIsFalse();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
