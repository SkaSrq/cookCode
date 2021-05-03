package com.example.cookcode.cookcode.controllers.users;

import com.example.cookcode.cookcode.entities.Questions;
import com.example.cookcode.cookcode.entities.Users;
import com.example.cookcode.cookcode.repositories.QuestionRepo;
import com.example.cookcode.cookcode.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

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

    @GetMapping("/practice/{page}")
    public String getPractice(@PathVariable("page") Integer page, Model model, Principal principal)
    {
        Pageable pageable=PageRequest.of(page,10);
        Page<Questions> list = questionRepo.findAll(pageable);
        model.addAttribute("question",list );
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",list.getTotalPages());
        return "usrs/practice";
    }
    @GetMapping("/view/{id}")
    public String viewQuestion(@PathVariable("id") Integer id, Model model, Principal principal)
    {
        Questions question= questionRepo.findByQuestionId(id);
        String dif = question.getDifficulty();
        model.addAttribute("diff", dif);
//        if(dif.equals("easy")||dif.equals("Easy"))
//        {
//            model.addAttribute("easy", dif);
////        }
//        if(dif.equals("medium")||dif.equals("Medium"))
//        {
//            model.addAttribute("medium", dif);
//        }
//        if(dif.equals("hard")||dif.equals("Hard"))
//        {
//            model.addAttribute("hard", dif);
//        }
        model.addAttribute("question",question);
        return "usrs/viewquestion";
    }
}
