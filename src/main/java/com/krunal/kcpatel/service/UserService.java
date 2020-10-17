package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.User;
import com.krunal.kcpatel.entity.UserOtp;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<String> saveUser(User user);

    ResponseEntity<String> updateUser(User user);

    User getUser(Long userId);

    List<User> users();

    ResponseEntity<String> deactiveUser(Long userId);

    List<User> allUsers();

    ResponseEntity<String> activeUser(Long userId);

    ResponseEntity<String> deleteUser(Long userId);

    List<User> deactiveUsers();

    List<User> deletedUsers();

    String generateOTP();

    ResponseEntity<String> forgotPassword(String userEmail);

    Object userEmailExist(String userEmail);

    Object userEmailExistCheckForUpdate(String userEmail,Long userId);

    ResponseEntity<String> confirmOtp(String userEmail, String userOtp);

}
