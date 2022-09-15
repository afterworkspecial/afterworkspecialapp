package com.afterworkspecial.afterworkspecial.repository;

import com.afterworkspecial.afterworkspecial.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
