package com.example.cookcode.cookcode.sevices;

import com.example.cookcode.cookcode.entities.Users;
import com.example.cookcode.cookcode.impls.UserPrincipal;
import com.example.cookcode.cookcode.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users loginModel = userRepo.findUsersByUsername(s);
        if(loginModel==null)
            throw  new UsernameNotFoundException("User Not Found");
        return new UserPrincipal(loginModel);

    }
}
