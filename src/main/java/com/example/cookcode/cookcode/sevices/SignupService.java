package com.example.cookcode.cookcode.sevices;

import com.example.cookcode.cookcode.entities.Users;
import com.example.cookcode.cookcode.repositories.UserRepo;
import com.example.cookcode.cookcode.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Service
public class SignupService {
    @Autowired
    UserRepo signupRepo;
    public void createUser(Users signupModel, boolean agreement, Model model, HttpSession session) {
        try {
            if(signupModel.getUsername().length()>10)
            {
                throw new Exception("Maximum length of username is 10.");
            }
            if (!agreement) {
                System.out.println("Please Accept Terms and Conditons.");
                throw new Exception("Please Accept Terms and Conditons.");
            }
            if (signupRepo.existsByUsername(signupModel.getUsername())) {
                throw new Exception("User Already Exist");
            }
            if (signupRepo.existsByEmail(signupModel.getEmail())) {
                throw new Exception("Email Already Exist");
            }
//            String line = signupModel.getPhone();
//            String pattern = "^[6-9][0-9]{9}$";
//            if(!line.matches(pattern)){
//                throw new Exception("Mobile Number is Not valid");
//            }
//            if(signupRepo.existsByPhone(line))
//            {
//                throw new Exception("Mobile Number Already Exist");
//            }
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String pass = encoder.encode(signupModel.getPassword());
//           Saving into SignupModel
            signupModel.setRole("ROLE_USER");
            signupModel.setEnabled(true);
            signupModel.setImage("contact.png");
            signupModel.setPassword(pass);
            signupRepo.save(signupModel);
            model.addAttribute("signup",new Users());
            session.setAttribute("message", new Message("Successfully Registered","alert-success"));
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("signup",signupModel);
            session.setAttribute("message", new Message("Something went wrong !!  "+e.getMessage(),"alert-danger"));
        }
    }
}
