package com.afterworkspecial.afterworkspecial.controllers;

import com.afterworkspecial.afterworkspecial.domain.User;
import com.afterworkspecial.afterworkspecial.domain.Whatsup;
import com.afterworkspecial.afterworkspecial.repository.CommentRepository;
import com.afterworkspecial.afterworkspecial.repository.UserRepository;
import com.afterworkspecial.afterworkspecial.repository.WhatsupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class UserController {

    private UserRepository userRepository;
    private WhatsupRepository whatsupRepository;
    private CommentRepository commentRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserRepository userRepository, WhatsupRepository whatsupRepository, CommentRepository commentRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.whatsupRepository = whatsupRepository;
        this.commentRepository = commentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.findByUsernameIs(username);
    }

    // /users/username
    // GET - user main page info?
    // right now it is returning user object
    @GetMapping("/users/{username}")
    public ResponseEntity<User> userMainPage(@PathVariable String username) {
        User user = userRepository.findByUsernameIs(username);
        if (user == null) return ResponseEntity.notFound().build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //
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
