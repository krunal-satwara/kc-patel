package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.User;
import com.krunal.kcpatel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user=userRepository.findByUserEmailAndStatusIsTrue(userEmail);
        String password= user.getUserPassword();
        return new MyUserDetails(user.getUserEmail(), password, user.getRoleId().toString());
    }
}
