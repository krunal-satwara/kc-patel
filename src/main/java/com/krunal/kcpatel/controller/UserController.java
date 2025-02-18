package com.krunal.kcpatel.controller;

import com.krunal.kcpatel.entity.*;
import com.krunal.kcpatel.service.MyUserDetailsService;
import com.krunal.kcpatel.service.NavigationMasterService;
import com.krunal.kcpatel.service.UserNavigationService;
import com.krunal.kcpatel.service.UserService;
import com.krunal.kcpatel.util.JwtUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private NavigationMasterService navigationMasterService;

    @Autowired
    private UserNavigationService userNavigationService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @ApiOperation(value = "Login User", response = Iterable.class)
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest request) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUserEmail(), request.getUserPassword())
            );
        } catch (Exception e) {
            throw new BadCredentialsException("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserEmail());

        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationReponse(jwt));
    }

    @PostMapping("/save")
    ResponseEntity<String> saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/update")
    ResponseEntity<String> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
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

    @PostMapping("/forgotPassword/{userEmail}")
    ResponseEntity<String> forgotPassword(@PathVariable("userEmail") String userEmail) {
        return userService.forgotPassword(userEmail);
    }

    @PostMapping("/confirmOtp/{userEmail}/{otp}")
    ResponseEntity<String> confirmOtp(@PathVariable("userEmail") String userEmail, @PathVariable("otp") String otp) {
        return userService.confirmOtp(userEmail, otp);
    }

    @GetMapping("/emailExist/{userEmail}")
    Object userEmailExist(@PathVariable("userEmail") String userEmail) {
        return userService.userEmailExist(userEmail);
    }

    @GetMapping("/emailExist/{userEmail}/{userId}")
    Object userEmailExistCheckForUpdate(@PathVariable("userEmail") String userEmail, @PathVariable("userId") Long userId) {
        return userService.userEmailExistCheckForUpdate(userEmail, userId);
    }

    @GetMapping("/opt")
    public String generateOTP() {
        return userService.generateOTP();
    }


    @GetMapping("/navigationMasterList")
    public List<NavigationMaster> navigationMasterList() {
        return navigationMasterService.navigationMasterList();
    }

    @PostMapping("/saveUserNavigation/{userId}")
    public ResponseEntity<String> saveUserNavigation(@RequestBody List<UserNavigation> userNavigation,@PathVariable("userId") Long userId) {
        return userNavigationService.saveUserNavigation(userId,userNavigation);
    }

    @GetMapping("/userSavedNavigationList/{userId}")
    public List<UserNavigation> userSavedNavigationList(@PathVariable("userId") Long userId) {
        return userNavigationService.userSavedNavigationList(userId);
    }

    @GetMapping("/filteredNavigationMasterList/{userId}")
    public List<NavigationMaster> filteredNavigationMasterList(@PathVariable("userId") Long userId) {
        return navigationMasterService.filteredNavigationMasterList(userId);
    }

}
