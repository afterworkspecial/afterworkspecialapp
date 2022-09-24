package com.afterworkspecial.afterworkspecial.controllers;

import com.afterworkspecial.afterworkspecial.domain.User;
import com.afterworkspecial.afterworkspecial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainPageController {

//    @GetMapping("/user/registration")
//    public String showRegistrationForm(WebRequest request, Model model) {
//        UserDto userDto = new UserDto();
//        model.addAttribute("user", userDto);
//        return "registration";
//    }

    UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public MainPageController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
    public ResponseEntity<?> registerUser(@RequestBody User user) {

        if (userRepository.existsByUsername(user.getUsername())) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        User newUser = new User(user.getUsername(), passwordEncoder.encode(user.getPassword()), user.getEmail(), user.getRole());

        userRepository.save(newUser);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
}