package com.example.cookcode.cookcode.controllers;

import com.example.cookcode.cookcode.entities.Users;
import com.example.cookcode.cookcode.sevices.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class Login {
        @Autowired
        LoginService loginService;

    @GetMapping("/login")
    public String loginPage(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication==null || authentication instanceof AnonymousAuthenticationToken){
            return "login";
        }
        return "redirect:index";
    }

    @PostMapping("/login")
    public void login(@ModelAttribute Users user, Model model, HttpSession session){
        loginService.login(user,model,session);
    }
}
