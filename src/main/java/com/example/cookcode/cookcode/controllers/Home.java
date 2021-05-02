package com.example.cookcode.cookcode.controllers;

import com.example.cookcode.cookcode.entities.Users;
import com.example.cookcode.cookcode.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class Home {
    @Autowired
    UserRepo loginRepo;
    @GetMapping("/")
    public String getHome()
    {
        return "index";
    }

    @GetMapping("/home")
    public String getHome(Model model, Principal principal){
        if(principal == null)
        {
            return "login";
        }
        String username=principal.getName();
        System.out.println(" User Logged In : USERNAME = "+username);
        Users login=loginRepo.findUsersByUsername(username);
        model.addAttribute("login",login);
        if(login.getRole().equals("ROLE_ADMIN")){
            return"redirect:/admin/home";
        }
        if(login.getRole().equals("ROLE_OWNER")){
            return "owners/home";
        }
        return "redirect:/user/home";
    }
}
