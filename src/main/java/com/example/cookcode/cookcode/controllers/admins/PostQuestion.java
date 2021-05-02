package com.example.cookcode.cookcode.controllers.admins;

import com.example.cookcode.cookcode.entities.Questions;
import com.example.cookcode.cookcode.entities.Users;
import com.example.cookcode.cookcode.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class PostQuestion {

//    @Autowired
//    UserRepo loginRepo;
//    @ModelAttribute
//    public void modelAdmin(Model model, Principal principal)
//    {
//        String username=principal.getName();
//        System.out.println(" User Logged In : USERNAME = "+username);
//        Users login=loginRepo.findUsersByUsername(username);
//        model.addAttribute("login",login);
//    }
//
//    @GetMapping("/admin/createquestion")
//    public String getPage(Model model)
//    {
//        model.addAttribute("question", new Questions() );
//        return "admns/questions/create/questions";
//    }

}
