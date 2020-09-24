package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<String> saveUser(User user);

    User getUser(Long userId);

    List<User> users();

    ResponseEntity<String> deactiveUser(Long userId);

    List<User> allUsers();

    ResponseEntity<String> activeUser(Long userId);

    ResponseEntity<String> deleteUser(Long userId);

    List<User> deactiveUsers();

    List<User> deletedUsers();

}
