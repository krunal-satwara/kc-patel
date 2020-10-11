package com.krunal.kcpatel.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class MyUserDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends  GrantedAuthority> authorities;

    public MyUserDetails(String username, String password, String roleId) {
        this.username = username;
        this.password = password;
        this.authorities = Collections.singletonList(new SimpleGrantedAuthority(roleId));
    }

    public static MyUserDetails create(String username, String  password, String rolename) {
        return new MyUserDetails(username, password, rolename);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
