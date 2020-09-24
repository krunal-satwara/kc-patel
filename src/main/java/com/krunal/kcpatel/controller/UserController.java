package com.krunal.kcpatel.controller;

import com.krunal.kcpatel.entity.User;
import com.krunal.kcpatel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    ResponseEntity<String> saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/users")
    List<User> users() {
        return userService.users();
    }

    @GetMapping("/allUsers")
    List<User> allUsers() {
        return userService.allUsers();
    }

    @GetMapping("/deactiveUsers")
    List<User> deactiveUsers() {
        return userService.deactiveUsers();
    }

    @GetMapping("/deletedUsers")
    List<User> deletedUsers() {
        return userService.deletedUsers();
    }

    @GetMapping("/activeUser/{userId}")
    ResponseEntity<String> activeUser(@PathVariable("userId") Long userId) {
        return userService.activeUser(userId);
    }

    @GetMapping("/deactiveUser/{userId}")
    ResponseEntity<String> deactiveUser(@PathVariable("userId") Long userId) {
        return userService.deactiveUser(userId);
    }

    @DeleteMapping("/deleteUser/{userId}")
    ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId) {
        return userService.deleteUser(userId);
    }


}
