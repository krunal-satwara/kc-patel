package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.User;
import com.krunal.kcpatel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<String> saveUser(User user) {
        try {
            userRepository.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public User getUser(Long userId) {
        try {
            return userRepository.findByUserId(userId);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> users() {
        try {
            return userRepository.findAllByStatusIsTrueAndDeleteStatusIsFalse();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseEntity<String> deactiveUser(Long userId) {
        try {
            User user = userRepository.findByUserId(userId);
            user.setStatus(false);
            userRepository.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public List<User> allUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseEntity<String> activeUser(Long userId) {
        try {
            User user = userRepository.findByUserId(userId);
            user.setStatus(true);
            userRepository.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> deleteUser(Long userId) {
        try {
            User user = userRepository.findByUserId(userId);
            user.setDeleteStatus(false);
            userRepository.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public List<User> deactiveUsers() {
        try {
            return userRepository.findAllByStatusIsFalseAndDeleteStatusIsFalse();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;

    }

    @Override
    public List<User> deletedUsers() {
        try {
            return userRepository.findAllByDeleteStatusIsTrue();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

}
