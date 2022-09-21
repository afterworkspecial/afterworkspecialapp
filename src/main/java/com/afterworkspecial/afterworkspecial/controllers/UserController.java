package com.afterworkspecial.afterworkspecial.controllers;

import com.afterworkspecial.afterworkspecial.domain.User;
import com.afterworkspecial.afterworkspecial.domain.Whatsup;
import com.afterworkspecial.afterworkspecial.repository.CommentRepository;
import com.afterworkspecial.afterworkspecial.repository.UserRepository;
import com.afterworkspecial.afterworkspecial.repository.WhatsupRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class UserController {

    private UserRepository userRepository;
    private WhatsupRepository whatsupRepository;
    private CommentRepository commentRepository;

    public UserController(UserRepository userRepository, WhatsupRepository whatsupRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.whatsupRepository = whatsupRepository;
        this.commentRepository = commentRepository;
    }

    private User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.findByUsernameIs(username);
    }

    // /users/username
    // GET - user main page info?
    @GetMapping("/users/{username}")
    public String userMainPage() {
        return "error - page does not exist";
    }
    @GetMapping("users/username/whatsup/{id}")
    public EntityModel<Whatsup> getWhatupById(@PathVariable Long id) {
        return EntityModel.of(whatsupRepository.findWhatsupById(id));
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
    public EntityModel<Whatsup> createNewWhatsup(@RequestBody Whatsup whatsup) {
        Whatsup newWhatusp = new Whatsup(
                getLoggedInUser(), whatsup.getText(), 0, LocalDateTime.now()
        );
        whatsupRepository.save(newWhatusp);
        return EntityModel.of(newWhatusp);
    }
}
