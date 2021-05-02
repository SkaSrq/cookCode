package com.example.cookcode.cookcode.controllers;

import com.example.cookcode.cookcode.entities.Users;
import com.example.cookcode.cookcode.sevices.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
@Controller
public class Signup {
    @Autowired
    SignupService signupService;
    @GetMapping("/signup")
    public String signupPage(Model model){
        model.addAttribute("title","Registeration");
        model.addAttribute("signup",new Users());
        return "signup";
    }
    @PostMapping("/signup")
    public String signupPage(@ModelAttribute("signup") Users signupModel, @RequestParam(value = "agreement",defaultValue = "false") boolean agreement, Model model, HttpSession session) throws Exception {
        signupService.createUser(signupModel, agreement, model, session);
        return "login";
    }
}
