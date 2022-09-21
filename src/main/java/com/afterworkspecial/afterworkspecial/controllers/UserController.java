package com.afterworkspecial.afterworkspecial.controllers;

import com.afterworkspecial.afterworkspecial.domain.Whatsup;
import com.afterworkspecial.afterworkspecial.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // /users/username
    // GET - user main page info?
    @GetMapping("/users/{username}")
    public String userMainPage() {
        return "usermainpage";
    }
    // /users/username/whatsup/{id}
    // GET - specific user whatsup by id
    @GetMapping("users/username/whatsup/{id}")
    public Whatsup getWhatupById() {
        return null;
    }
    // PATCH - update specific whatsup
    @PatchMapping("users/username/whatsup/{id}")
    public String updateWhatupById() {
        return "error";
    }
    // DELETE - delete whatsup by id
    @DeleteMapping("users/username/whatsup/{id}")
    public String deleteWhatUpById() {
        return "error";
    }
    // /users/username/whatsup/
    // POST - create new whatsup
    @PostMapping("users/username/whatsup")
    public String createNewWhatsup() {
        return "error";
    }
}
