package com.afterworkspecial.afterworkspecial.repository;

import com.afterworkspecial.afterworkspecial.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameIs(String name);
}
