package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.UserNavigation;
import com.krunal.kcpatel.repository.UserNavigationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserNavigationServiceImpl implements UserNavigationService {

    @Autowired
    private UserNavigationRepository userNavigationRepository;

    @Override
    public ResponseEntity<String> saveUserNavigation(List<UserNavigation> userNavigation) {
        try {
            for (UserNavigation navigation:userNavigation) {
                userNavigationRepository.save(navigation);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public List<UserNavigation> userSavedNavigationList(Long userId) {
        return userNavigationRepository.findAllByUserId(userId);
    }

}
