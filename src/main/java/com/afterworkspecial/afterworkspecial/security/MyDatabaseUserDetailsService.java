package com.afterworkspecial.afterworkspecial.security;

import com.afterworkspecial.afterworkspecial.domain.User;
import com.afterworkspecial.afterworkspecial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MyDatabaseUserDetailsService implements UserDetailsService {

    UserRepository userRepository;

    @Autowired
    public MyDatabaseUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User dbUser =  userRepository.findAll().stream()
                .filter(customer -> customer.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s not found", username)));

        // Narazie nie mamy autoryzacji więc kolekcja jest pusta
        return new org.springframework.security.core.userdetails.User(dbUser.getUsername(),
                new BCryptPasswordEncoder().encode(dbUser.getPassword()), Collections.emptyList());
    }
}
