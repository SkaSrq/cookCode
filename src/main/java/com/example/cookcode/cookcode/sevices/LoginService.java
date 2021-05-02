package com.example.cookcode.cookcode.sevices;

import com.example.cookcode.cookcode.entities.Users;
import com.example.cookcode.cookcode.repositories.UserRepo;
import com.example.cookcode.cookcode.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Service
public class LoginService {
    @Autowired
    UserRepo userRepo;
    public void login(Users user, Model model, HttpSession session) {
        Users userModel = userRepo.findUsersByUsername(user.getUsername());
        System.out.println(userModel);
        try{
            if (userModel == null){
                System.out.println("User Not Found");
                throw new Exception("User Not Found");}
            if(!user.getPassword().equals(userModel.getPassword())){
                throw new Exception("Wrong Password");
            }
            model.addAttribute("login",new Users());

        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("login",user);
            session.setAttribute("message",new Message("Something went wrong !!  "+e.getMessage(),"alert-danger"));
        }

    }
}
