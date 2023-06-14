package com.example.ph26840.assigment.controller;

import com.example.ph26840.assigment.entity.Users;
import com.example.ph26840.assigment.repository.IUserRepository;
import com.example.ph26840.assigment.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new Users());
        return "assigment/login/login";
    }

    @PostMapping("/login")
    public String checkLogin(Model model,
                             @Valid @ModelAttribute("user") Users user,
                             BindingResult result,
                             HttpSession session
    ) {
        //1 validate
        if(result.hasErrors()) {
            return "assigment/login/login";
        }

        //2 login success
        Users userFromDB = userRepository.findAllByTenAndPass(user.getTen(),user.getPass());
        if(userFromDB != null) {
            session.setAttribute("userLogged", userFromDB);
//            session.setAttribute("x", user.getTen());
            return "redirect:admin/khan/hien-thi";
        }

        //3 login failed
        model.addAttribute("message", "Username or password incorrect");
        return "assigment/login/login";
    }

    //Register dang ky
    //Đăng ký
    @GetMapping("/register")
    public String ShowRegisterForm(Model model){
        model.addAttribute("user", new Users());
        return "assigment/login/sign-in";
    }
    @PostMapping("/register")
    public String RegisterUser(@ModelAttribute("user")Users users,BindingResult result,Model model){
        if(result.hasErrors()){
            return "assigment/login/sign-in";
        }
        if(userService.checkUsername(users.getTen())){
            model.addAttribute("emailError","Email already exists");
            return "assigment/login/sign-in";
        }
        userService.save(users);
        return "redirect:/login";

    }


}
