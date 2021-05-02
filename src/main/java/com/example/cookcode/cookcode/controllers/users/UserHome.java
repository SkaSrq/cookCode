package com.example.cookcode.cookcode.controllers.users;

import com.example.cookcode.cookcode.entities.Questions;
import com.example.cookcode.cookcode.entities.Users;
import com.example.cookcode.cookcode.repositories.QuestionRepo;
import com.example.cookcode.cookcode.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserHome {
    @Autowired
    UserRepo loginRepo;
    @Autowired
    QuestionRepo questionRepo;

    @ModelAttribute
    public void addToAll(Model model, Principal principal)
    {
        String username=principal.getName();
        System.out.println(" User Logged In : USERNAME = "+username);
        Users login=loginRepo.findUsersByUsername(username);
        model.addAttribute("login",login);
    }


    @GetMapping("/home")
    public String userHome(Model model, Principal principal)
    {
        return "usrs/home";
    }

    @GetMapping("/practice")
    public String getPractice(Model model, Principal principal)
    {
        List<Questions> list = questionRepo.findAll();
        model.addAttribute("question",list );
        return "usrs/practice";
    }
}
