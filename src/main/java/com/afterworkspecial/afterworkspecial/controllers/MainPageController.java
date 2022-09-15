package com.afterworkspecial.afterworkspecial.controllers;

import com.afterworkspecial.afterworkspecial.domain.User;
import com.afterworkspecial.afterworkspecial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainPageController {

//    @GetMapping("/user/registration")
//    public String showRegistrationForm(WebRequest request, Model model) {
//        UserDto userDto = new UserDto();
//        model.addAttribute("user", userDto);
//        return "registration";
//    }

    UserRepository userRepository;

    @Autowired
    public MainPageController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String home() {
        return "main";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String successfulLogin() {
        return "home";
    }

    @GetMapping("/register")
    public String successfulRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String createNewUserWithRegistration(@ModelAttribute User user, Model model) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "home";
    }
}