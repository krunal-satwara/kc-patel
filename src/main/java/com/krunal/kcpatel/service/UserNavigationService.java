package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.UserNavigation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserNavigationService {
    ResponseEntity<String> saveUserNavigation(List<UserNavigation> userNavigation);

    List<UserNavigation> userSavedNavigationList(Long userId);
}
