package com.example.cookcode.cookcode.controllers.admins;

import com.example.cookcode.cookcode.entities.Questions;
import com.example.cookcode.cookcode.entities.Users;
import com.example.cookcode.cookcode.repositories.QuestionRepo;
import com.example.cookcode.cookcode.repositories.UserRepo;
import com.example.cookcode.cookcode.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequestMapping("/admin/question")
public class AdminQuestions {
    @Autowired
    UserRepo loginRepo;

    @Autowired
    QuestionRepo questionRepo;
    static int count = 0;

    @ModelAttribute
    public void addToAll(Model model, Principal principal)
    {
        String username=principal.getName();
        System.out.println(" User Logged In : USERNAME = "+username);
        Users login=loginRepo.findUsersByUsername(username);
        model.addAttribute("login",login);
    }

    @GetMapping("/create")
    public String getPage(Model model)
    {
        model.addAttribute("question",new Questions());
        return "admns/question";
    }

    @PostMapping("/create")
    public String createQuestion(@ModelAttribute Questions question, Model model, HttpSession session, Principal principal)
    {
        question.setQuestionId(count++);
        question.setPostedBy(principal.getName());
        questionRepo.save(question);
        model.addAttribute("signup",new Questions());
        session.setAttribute("message", new Message("Successfully Posted","alert-success"));
        return "admns/question";
    }

}
