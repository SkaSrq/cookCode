package com.example.cookcode.cookcode.impls;

import com.example.cookcode.cookcode.entities.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {
    private final Users loginModel;
    public UserPrincipal(Users loginModel) {
        super();
        this.loginModel = loginModel;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(loginModel.getRole());
        list.add(simpleGrantedAuthority);
        return list;
    }

    @Override
    public String getPassword() {
        return loginModel.getPassword();
    }

    @Override
    public String getUsername() {
        return loginModel.getUsername();
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
